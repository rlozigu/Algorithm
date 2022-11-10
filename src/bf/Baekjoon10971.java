package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon10971 {
    static boolean nextPermutation(int[] a){
        int i = a.length - 1;
        while (i > 0 && a[i] <= a[i - 1]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] <= a[i-1]){
            j--;
        }

        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;

        j = a.length - 1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i ++;
            j --;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[] con = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
            con[i] = i;
        }

        int result = Integer.MAX_VALUE;
        do {
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[con[i]][con[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum += arr[con[i]][con[i + 1]];
                }
            }

            if (ok && arr[con[n - 1]][con[0]] != 0) {
                sum += arr[con[n - 1]][con[0]];
                if (result > sum) {
                    result = sum;
                }
            }
        } while (nextPermutation(con));

        System.out.println(result);
    }
}
