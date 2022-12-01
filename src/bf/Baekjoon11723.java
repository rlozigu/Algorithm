package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int result = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;

            switch (str) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    result = result | (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    result= result & ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    int ck = result & (1 << num);
                    if(ck > 0) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    result = result ^ (1 << num);
                    break;
                case "all":
                    result = (1 << m) - 1;
                    break;
                case "empty":
                    result = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}
