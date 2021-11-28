package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] d = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = arr[0];
        int result = arr[0];
        for(int i = 1; i < n; i++){
            d[i] = arr[i];
            int tmp = d[i - 1] + arr[i];

            if(tmp > arr[i]){
                d[i] = tmp;
            }

            result = (result>d[i])?result:d[i];
        }

        System.out.println(result);
    }
}
