package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int [n+1][10];

        dp[1][0] = dp[1][1] =dp[1][2] = dp[1][3] =dp[1][4] = dp[1][5] =dp[1][6] = dp[1][7] =dp[1][8] = dp[1][9] =1;

        for(int i=2;i<=n;i++) {
            for(int j=0;j<10;j++) {
                for(int k=0;k<=j;k++) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }

        }

        int sum = 0;
        for(int i=0;i<10;i++) {
            sum+=dp[n][i];
        }

        System.out.println(sum % 10007);

    }

}