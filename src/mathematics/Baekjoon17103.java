package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[1000001];

        check[0] = check[1] = true;

        for (int i = 2; i <= 1000000; i++) {
            if(check[i]) continue;

            for (int j = i * 2; j <= 1000000; j += i) {
                check[j] = true;
            }
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            for (int j = 2; j * 2 <= n; j++) {
                if(check[j] == false && check[n - j] == false) result++;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
