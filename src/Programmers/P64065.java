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

        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();});

        int[] answer = new int[arr.length];
        int idx = 0;

        Set<String> set = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        for (String str:arr) {
            String[] tmp = str.split(",");
            for (String t:tmp) {
                if(set.add(t)){
                    answer[idx++] = Integer.parseInt(t);
                }
            }
        }
        return answer;
    }
}
