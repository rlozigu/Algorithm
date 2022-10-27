package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken()) - 1;
        int S = Integer.parseInt(st.nextToken()) - 1;
        int M = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; ; i++) {
            if(E == i % 15 && S == i % 28 && M == i % 19) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
