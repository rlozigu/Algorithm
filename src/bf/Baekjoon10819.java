package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10819 {
    static boolean nextPermutation(int[] a){
        int i = a.length - 1;

        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length -1;
        while (a[j] <= a[i-1]){
            j -= 1;
        }

        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;

        j = a.length - 1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i += 1;
            j -= 1;
        }

        return true;
    }

    static int calcualte(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            result += (arr[i] - arr[i + 1] > 0) ? arr[i] - arr[i + 1] : -(arr[i] - arr[i + 1]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        do {
            int tmp = calcualte(arr);
            result = Math.max(tmp, result);
        } while (nextPermutation(arr));

        System.out.println(result);
    }
}
