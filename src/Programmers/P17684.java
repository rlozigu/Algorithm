package Programmers;

import java.util.ArrayList;
import java.util.List;

public class P17684 {
    public static void main(String[] args) {
        int[] arr = solution("ABABABABABABABAB");
        for (int result : arr) {
            System.out.println(result);
        }

    }

    static int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        list.add("");

        msg = msg + "0";
        for (int i = 65; i <= 90; i++) {
            list.add((char)i + "");
        }

        List<Integer> answer = new ArrayList<>();
        int index = -1;

        Loop1:
        for (int i = 0; i < msg.length()-1; i++) {
            index++;
            answer.add(list.indexOf(msg.charAt(i) + ""));
            for (int j = i+2; j <= msg.length(); j++) {
                String str = msg.substring(i, j);
                int tmp = list.indexOf(str);

                if (tmp == -1){
                    list.add(str);
                    i = j-2;
                    continue Loop1;
                }else{
                    answer.set(index, tmp);
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
