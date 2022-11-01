package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        int start = 1;
        for (int i = 1; start <= n; i++) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            result += (long)(end - start + 1) * i;
            start *= 10;
        }

        System.out.println(result);

    }
}
