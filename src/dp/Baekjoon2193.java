package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] d = new long[2][n+1];

        d[0][1] = 0;
        d[1][1] = 1;

        for(int i = 2; i <= n; i++){
            d[0][i] = d[0][i-1] + d[1][i-1];
            d[1][i] = d[0][i-1];
        }

        System.out.println(d[0][n] + d[1][n]);
    }
}
