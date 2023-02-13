package Programmers;

public class P118666 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }

    static String solution(String[] survey, int[] choices) {
        int[] result = new int[4];

        for (int i = 0; i < survey.length; i++) {
            char ch = survey[i].charAt(0);
            int choice = choices[i] - 4;

            switch (ch) {
                case 'R':
                    result[0] += choice;
                    break;
                case 'T':
                    result[0] -= choice;
                    break;
                case 'C':
                    result[1] += choice;
                    break;
                case 'F':
                    result[1] -= choice;
                    break;
                case 'J':
                    result[2] += choice;
                    break;
                case 'M':
                    result[2] -= choice;
                    break;
                case 'A':
                    result[3] += choice;
                    break;
                case 'N':
                    result[3] -= choice;
                    break;
            }
        }

        String answer = "";
        if (result[0] > 0){
            answer += "T";
        }else {
            answer += "R";
        }

        if (result[1] > 0){
            answer += "F";
        }else {
            answer += "C";
        }

        if (result[2] > 0){
            answer += "M";
        }else {
            answer += "J";
        }

        if (result[3] > 0){
            answer += "N";
        }else {
            answer += "A";
        }

        return answer;
    }
}
