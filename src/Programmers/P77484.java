package Programmers;

import java.util.Arrays;

public class P77484 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] result = solution(lottos, win_nums);
    }

    static int[] solution(int[] lottos, int[] win_nums) {
        int ok = 0;
        int zero = 0;
        for (int i : lottos) {
            if (i == 0) {
                zero++;
            } else {
                if(Arrays.stream(win_nums).anyMatch(a -> a == i)){
                    ok++;
                };
            }
        }

        System.out.println(ok);
        System.out.println(zero);

        int min = (ok < 2) ? 6 : 7 - ok;
        int max = (ok+zero < 2) ? 6 : 7 - (ok+zero);


        int[] answer = {max, min};
        return answer;
    }
}
