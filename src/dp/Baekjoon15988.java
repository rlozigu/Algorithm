package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int mod = 1000000009;

        int t = Integer.parseInt(br.readLine());
        long[] d = new long[1000001];

        d[0] = d[1] = 1;
        d[2] = 2;

        for (int j = 3; j <= 1000000; j++) {
            d[j] = (d[j-3] + d[j-2] +d[j-1] ) % mod;
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(d[n]).append("\n");
        }
        System.out.println(sb);
    }
}
