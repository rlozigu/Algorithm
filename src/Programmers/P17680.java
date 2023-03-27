package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P17680 {
    public static void main(String[] args) {
        int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        System.out.println(solution(cacheSize, cities));
    }

    static int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();

        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            if(q.remove(city)){
                q.add(city);
                answer += 1;
            }else{
                if(q.size() == cacheSize) q.remove();
                q.add(city);
                answer += 5;
            }
      }
        return answer;
    }
}
