package Programmers;

import java.util.ArrayList;
import java.util.List;

public class P17682 {
    public static void main(String[] args) {
        System.out.println(solution("1D2S0T"));
    }

    static int solution(String dartResult) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < dartResult.length(); i = i+2) {
            int score = dartResult.charAt(i) - '0';

            if(dartResult.charAt(i+1) == '0'){
                score = 10;
                i++;
            }

            switch (dartResult.charAt(i+1)) {
                case 'S':
                    break;
                case 'D':
                    score = (int)Math.pow(score, 2);
                    break;
                case 'T':
                    score = (int)Math.pow(score, 3);
                    break;
            }

            if (dartResult.length() > i + 2) {
                switch (dartResult.charAt(i+2)){
                    case '*':
                        score = score * 2;
                        if(idx > 0) list.set(idx-1, list.get(idx-1) * 2);
                        i++;
                        break;
                    case '#':
                        score = -score;
                        i++;
                        break;
                }
            }


            list.add(score);
            idx++;
        }
        int answer = 0;
        for (int i:list) {
            answer += i;
        }
        return answer;
    }
}
