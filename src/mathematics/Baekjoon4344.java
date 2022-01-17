package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] scores = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                scores[j] = num;
                sum += num;
            }
            double avg = sum / (n * 1.0);
            double num = 0;
            for (int t = 0; t < n; t++) {
                if (scores[t] > avg) {
                    num++;
                }
            }

            System.out.printf("%.3f%%\n",(num/n)*100);
        }
    }
}