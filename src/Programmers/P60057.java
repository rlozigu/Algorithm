package Programmers;

import java.sql.SQLOutput;

public class P60057 {
    public static void main(String[] args) {
        System.out.println("abcd".substring(0, 4));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    static int solution(String s) {
        int len = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String answer = "";
            int n = 1;
            boolean isEqual = true;
            int rest = s.length() % i;
            for (int j = i; i+j <= s.length(); j = j + i) {
                String prev = s.substring(j - i, j);
                String next = s.substring(j, j + i);
                if (prev.equals(next)) {
                    n++;
                    isEqual = true;
                    if(j+i < s.length()-rest)continue;
                }else{
                    isEqual = false;
                }

                if (n == 1) {
                    answer = answer + prev;
                }else if(n > 1) {
                        answer = answer + n + prev;
                        n = 1;
                    }
                if (j + i == s.length() - rest && !isEqual){
                    answer += next;
                }

            }
            answer += s.substring(s.length() - rest);
            len = Math.min(len, answer.length());
        }
        return len;
    }
}
