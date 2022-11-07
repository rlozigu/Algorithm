package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10974 {
    static boolean nextPermatation(int[] arr){
        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = arr.length -1;
        while (arr[j] <= arr[i-1]){
            j -= 1;
        }

        int tmp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = tmp;

        j = arr.length - 1;
        while (i < j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i += 1;
            j -= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        do {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } while (nextPermatation(arr));

        System.out.println(sb);

    }
}
