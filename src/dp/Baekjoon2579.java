package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] d = new int[n+1];

        for(int i =1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        d[1] = arr[1];
        if(n > 1){
            d[2] = arr[1] + arr[2];
        }

        for(int i = 3; i < n+1 ; i++){
            d[i] = Math.max(d[i-2], d[i-3] + arr[i-1]) + arr[i];

        }

        System.out.println(d[n]);
    }
}
