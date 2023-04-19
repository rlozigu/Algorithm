package Programmers;

public class P17687 {
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 2));
    }

    static String solution(int n, int t, int m, int p) {
        int num = 0;
        String str = "0";
        while (true) {
            str += Integer.toString(++num, n).toUpperCase();
            if (str.length() >= m*t) break;
        }
        System.out.println(str);
        String answer = "";
        for (int i = 0; i < t; i++) {
            answer += str.charAt(i*m + p - 1);
        }
        return answer;
    }
}
