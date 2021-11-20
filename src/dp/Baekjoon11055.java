package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* TEST CASE
* 10
* 1 100 2 50 60 3 5 6 7 8
*/
public class Baekjoon11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        long[] dp = new long[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        long result = dp[0];

        for(int i = 1; i<n; i++){
            dp[i] = arr[i];

            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j] + arr[i] > dp[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }

            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
