package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class P42889 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};

        solution(n, arr);
    }

    static int[] solution(int N, int[] stages) {
        int[][] arr = new int[N][2];

        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i]-1;
            if(stage < N ) arr[stage][0]++;
            if(stage == N ) stage--;

            for (int j = stage; j >= 0 ; j--) {
                arr[j][1]++;
            }
        }

        double[][] failure = new double[N][2];
        for (int i = 0; i < N; i++) {
            failure[i][0] = i+1;
            failure[i][1] = (double)arr[i][0] / (double)arr[i][1];
            if(arr[i][1] == 0) failure[i][1] = 0;
        }

        Arrays.sort(failure, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return o1[1]!=o2[1] ? (o1[1]-o2[1]<0?1:-1) : (o1[0]-o2[0]<0?-1:1);
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int)failure[i][0];
        }
        return answer;
    }
}

