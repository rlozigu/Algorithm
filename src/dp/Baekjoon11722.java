package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        int result = 1;

        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i ; j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
