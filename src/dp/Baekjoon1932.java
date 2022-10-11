package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        int[][] d = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= i; j++) {
                d[i][j] = Math.max(d[i-1][j], d[i-1][j-1]) + arr[i][j];
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, d[n][i]);
        }

        System.out.println(result);
    }
}
