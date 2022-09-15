package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean check[] = new boolean[1000001];

        check[0] = check[1] = true;

        for (int i = 2; i <= 1000000; i++) {
            if(check[i])continue;

            for (int j = i * 2; j <= 1000000; j += i) {
                check[j] = true;
            }
        }

        Loop1:
        while (true) {
            int t = Integer.parseInt(br.readLine());

            if(t == 0)break;

            for (int j = t - 1; j * 2 >= t; j = j - 2) {
                if (!(check[t - j] || check[j])) {
                    sb.append(t).append(" = ").append(t - j).append(" + ").append(j).append("\n");
                    continue Loop1;
                }
            }
            sb.append("Goldbach's conjecture is wrong.").append("\n");
        }

        System.out.println(sb);
    }
}
