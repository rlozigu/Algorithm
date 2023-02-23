package Programmers;

import java.util.*;

public class P42889 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};

        solution(n, arr);
    }

    static int[] solution(int N, int[] stages) {
        int nPlayers = stages.length;
        int[] nStagePlayers = new int[N + 2];
        for (int stage : stages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stage = new ArrayList<>();
        for (int id = 1 ; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stage.add(s);
        }
        Collections.sort(stage, Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stage.get(i).id;
        }
        return answer;
    }

    static class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id_, double failure_) {
            id = id_;
            failure = failure_;
        }

        @Override
        public int compareTo(Stage o) {
            if (failure < o.failure ) {
                return -1;
            }
            if (failure > o.failure ) {
                return 1;
            }
            return 0;
        }
    }
}

