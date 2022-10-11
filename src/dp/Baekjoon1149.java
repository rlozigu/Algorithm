package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] d = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + Integer.parseInt(st.nextToken());
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + Integer.parseInt(st.nextToken());
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.min(Math.min(d[n][0], d[n][1]),d[n][2]));
    }
}
