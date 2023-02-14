package Programmers;

import java.util.*;
import java.util.stream.IntStream;

public class P92334 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] result = solution(id_list, report, k);
        for (int x :
                result) {
            System.out.print(x + " ");
        }
    }

    static int[] solution(String[] id_list, String[] report, int k) {
        Set<Integer>[] set = new HashSet[id_list.length];

        for (int i = 0; i < set.length; i++) {
            set[i] = new HashSet<>();
        }

        for (int i = 0; i < report.length; i++) {
            String arr[] = report[i].split(" ");
            int x = IntStream.range(0, id_list.length)
                    .filter(j -> arr[0].equals(id_list[j]))
                    .findFirst()
                    .orElse(-1);
            int y = IntStream.range(0, id_list.length)
                    .filter(j -> arr[1].equals(id_list[j]))
                    .findFirst()
                    .orElse(-1);

            set[x].add(y);
        }

        int[] arr = new int[id_list.length];
        int[] answer = new int[id_list.length];
        for (int i = 0; i < set.length; i++) {
            for (int x: set[i]) {
                arr[x]++;
            }
        }

        for (int i = 0; i < set.length; i++) {
            for (int x: set[i]) {
                if (arr[x] >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}

