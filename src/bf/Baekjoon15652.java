package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15652 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];


        go(0, 1);
        System.out.println(sb);
    }

    static void go(int index, int start){
        if (index == m) {
            String result = "";
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[index] = i;

            go(index + 1, i);
        }
    }
}
