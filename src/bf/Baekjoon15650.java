package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15650 {
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


        go(1, 0);
        System.out.println(sb);
    }

    static void go(int index, int selected){
        if (selected == m) {
            String result = "";
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (index > n) {
            return;
        }

        arr[selected] = index;
        go(index + 1, selected + 1);
        arr[selected] = 0;
        go(index + 1, selected);
    }
}
