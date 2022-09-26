package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        long[][] d = new long[100001][4];

        d[1][1] = d[2][2] = d[3][1] = d[3][2] = d[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            d[i][1] = (d[i-1][2] + d[i-1][3]) % 1000000009;
            d[i][2] = (d[i-2][1] + d[i-2][3]) % 1000000009;
            d[i][3] = (d[i-3][1] + d[i-3][2]) % 1000000009;
        }


        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());

            sb.append((d[num][1] + d[num][2] + d[num][3]) % 1000000009).append("\n");
        }

        System.out.println(sb);
    }
}
