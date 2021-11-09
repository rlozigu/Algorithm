package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Baekjoon9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t= Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++) {
            int n= Integer.parseInt(br.readLine());


            int[][] cost = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            cost[0] =Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cost[1] =Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dp[0][1] = cost[0][0];
            dp[1][1] = cost[1][0];


            for(int k=2;k<=n;k++) {
                dp[0][k] = Math.max( dp[1][k-1], dp[1][k-2])+cost[0][k-1];
                dp[1][k] = Math.max(dp[0][k-1],dp[0][k-2])+cost[1][k-1];
            }

            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }

        System.out.println(sb);
    }
}
