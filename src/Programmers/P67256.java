package Programmers;

public class P67256 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        System.out.println(solution(arr, hand));
    }

    static String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        for (int i:numbers) {
            switch (i) {
                case 1:
                case 4:
                case 7:
                    answer += "L";
                    left = i;
                    break;
                case 3:
                case 6:
                case 9:
                    answer += "R";
                    right = i;
                    break;
                case 0:
                    i = 11;
                case 2:
                case 5:
                case 8:
                    int distL = Math.abs(i - left) / 3 + Math.abs(i - left) % 3;
                    int distR = Math.abs(i - right) / 3 + Math.abs(i - right) % 3;

                    if (distL < distR) {
                        answer += "L";
                        left = i;
                    } else if (distL > distR) {
                        answer += "R";
                        right = i;
                    }else{
                        switch (hand) {
                            case "left":
                                answer += "L";
                                left = i;
                                break;
                            case "right":
                                answer += "R";
                                right = i;
                        }
                    }
            }
        }
        return answer;
    }
}
