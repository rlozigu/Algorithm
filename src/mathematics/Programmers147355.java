package mathematics;

import java.util.Locale;
import java.util.Scanner;

public class Programmers147355 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String p = sc.nextLine();

        System.out.println(solution(t, p));
    }

    private static int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            if (Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }
}
