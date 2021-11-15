package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        if (n < 100) {
            result = n;
        }else {
            result = 99;
            if (n == 1000) {
                    n = 999;
            }

            for (int i = 100; i <= n; i++) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
