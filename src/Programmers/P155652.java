package Programmers;


public class P155652 {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s, skip, index));
    }

    static String solution(String s, String skip, int index) {
        String answer = "";
        for (char ch: s.toCharArray()) {
            char tmp = ch;
            int idx = 0;
            while (idx < index) {
                tmp = (tmp == 'z') ? 'a' : (char) (tmp + 1);
                if (!skip.contains(String.valueOf(tmp))) {
                    idx++;
                }
            }
            answer += tmp;
        }

        return answer;
    }
}
