package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < n ; i++) {
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - s);
            result = getGcd(result, arr[i]);
        }

        System.out.println(result);
    }

    static int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}
