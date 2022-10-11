package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] d1 = new int[n];
        int[] d2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d1[0] = arr[0];
        for (int i = 1; i < n; i++){
            d1[i] = arr[i];
            if(d1[i] < d1[i-1] + arr[i]){
                d1[i] = d1[i-1] + arr[i];
            }
        }

        d2[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--){
            d2[i] = arr[i];
            if(d2[i] < d2[i+1] + arr[i]){
                d2[i] = d2[i+1] + arr[i];
            }
        }

        int result = d1[0];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, d1[i]);
        }
        for (int i = 1; i < n-1; i++) {
            result = Math.max(result, d1[i-1] + d2[i+1]);
        }

        System.out.println(result);


    }
}
