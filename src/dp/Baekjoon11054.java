package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] d1 = new int[n];
        int[] d2 = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d1[0] = 1;
        for(int i = 1; i < n ; i++){
            d1[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    d1[i] = Math.max(d1[j]+1, d1[i]);
                }
            }
        }

        d2[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            d2[i] = 1;
            for(int j = n-1; j > i; j--){
                if(arr[j] < arr[i]){
                    d2[i] = Math.max(d2[j]+1, d2[i]);
                }
            }
        }

        int result = 0;
        for(int i = 0; i<n; i++){
            result = Math.max(result, d1[i] + d2[i] -1);
        }

        System.out.println(result);

    }
}
