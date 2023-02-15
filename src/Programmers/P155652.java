package Programmers;


public class P155652 {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s, skip, index));
    }

    static String solution(String s, String skip, int index) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = index; j > 0; j--) {
                char tmp = (((int)arr[i] + 1) > 122)?'a':(char) ((int)arr[i] + 1);
                arr[i] = tmp;
                if(skip.chars().anyMatch(a -> a==tmp)){
                    j++;
                };
            }
        }

        String answer = "";
        for (char c:arr) {
            answer+=c;
        }
        return answer;
    }
}
