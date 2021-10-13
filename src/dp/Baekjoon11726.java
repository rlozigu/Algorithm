package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];

        System.out.println(recur(dp, n));
        br.close();
    }

    public static int recur(int[] dp, int num){
        if(num == 1 || num == 0){
            return 1;
        }
        if(dp[num] == 0){
            dp[num] = (recur(dp,num-1) + recur(dp, num-2)) % 10007;
        }
        return dp[num];
    }

}
