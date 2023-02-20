package Programmers;

public class P67256 {
    static int[][] keypad = {
             {3, 1}
            ,{0, 0}
            ,{0, 1}
            ,{0, 2}
            ,{1, 0}
            ,{1, 1}
            ,{1, 2}
            ,{2, 0}
            ,{2, 1}
            ,{2, 2}
    };

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        System.out.println(solution(arr, hand));
    }

    static String solution(int[] numbers, String hand) {
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};

        String answer = "";
        for (int i:numbers) {
            String str = pushNumber(i, leftPos, rightPos, hand);
            answer += str;

            if(str == "R") rightPos = keypad[i];
            if(str == "L") leftPos = keypad[i];
        }

        return answer;
    }

    static String pushNumber(int num, int[] left, int[] right, String hand){
        if (num == 1 || num == 4 || num == 7) return "L";
        if (num == 3 || num == 6 || num == 9) return "R";

        if (getDist(left, num) > getDist(right, num)) return "R";
        if (getDist(left, num) < getDist(right, num)) return "L";

        return hand.equals("right")?"R":"L";
    }

    static int getDist(int[] pos, int num) {
        return Math.abs(pos[0] - keypad[num][0]) + Math.abs(pos[1] - keypad[num][1]);
    }

}
