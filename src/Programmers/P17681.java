package Programmers;

public class P17681 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        System.out.println(solution(n, arr1, arr2));
    }

    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String str1 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            String str2 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));

            String result = "";
            for (int j = 0; j < n; j++) {
                result += (str1.charAt(j) == '0' && str2.charAt(j) == '0')?" ":"#";
            }
            answer[i] = result;
        }

        return answer;
    }
}
