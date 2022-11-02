package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15651 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] isUsed;
    static int[] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isUsed = new boolean[n + 1];
        arr = new int[m];


        go(0);
        System.out.println(sb);
    }

    static void go(int index){
        if (index == m) {
            String result = "";
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            isUsed[i] = true;

            go(index + 1);
            isUsed[i] = false;
        }
    }
}
