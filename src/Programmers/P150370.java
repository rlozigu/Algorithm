package Programmers;

import java.util.*;

public class P150370 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] arr = solution(today, terms, privacies);
        for (int a:arr) {
            System.out.print(a + " ");
        }
    }

    private static int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        int to = getDate(today);

        for (int i = 0; i < terms.length; i++) {
            String[] t = terms[i].split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + map.get(privacy[1]) * 28 <= to) {
                list.add(i + 1);
            }

        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return (year*12*28) + (month*28) + day;
    }
}
