package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;

        for (int i = 1; i <= 7980; i++) {
            if(E == e && S == s && M == m) {
                System.out.println(i);
                return;
            }

            e++;
            s++;
            m++;

            if (i % 15 == 0) {
                e = 1;
            }
            if (i % 28 == 0) {
                s = 1;
            }
            if (i % 19 == 0) {
                m = 1;
            }

        }
    }
}
