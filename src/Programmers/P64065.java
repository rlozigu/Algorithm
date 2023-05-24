package Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class P64065 {
    public static void main(String[] args) {

        System.out.println(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }

    static int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        String[] arr = s.split("},\\{");

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        List<Integer> list = new ArrayList<>();
        for (String str:arr) {
            String[] tmp = str.split(",");
            for (String t:tmp) {
                list.add(Integer.parseInt(t));
            }
        }
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
