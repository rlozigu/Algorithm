package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n][10];
        for(int i = 1; i < 10; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for(int j = 1; j < 9; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp[n-1][i];
        }
        System.out.println(sum % 1000000000);
    }
}
