package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int i = n - 1;
        while (i > 0 && arr[i-1] >= arr[i]){
            i -= 1;
        }

        if(i <= 0){
            System.out.println(-1);
            return;
        }

        int j = n -1;
        while (arr[j] <= arr[i-1]){
            j -= 1;
        }

        int tmp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = tmp;

        j = n -1;
        while (i < j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i += 1;
            j -= 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            sb.append(arr[k]).append(" ");
        }

        System.out.println(sb);
    }
}
