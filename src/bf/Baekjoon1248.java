package bf;

import java.util.Scanner;

public class Baekjoon1248 {
    static int n;
    static int[][] sign;
    static int[] result;

    static boolean check(int index) {
        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += result[i];
            if (sign[i][index] == 0) {
                if (sum != 0) {
                    return false;
                }
            } else if (sign[i][index] < 0) {
                if (sum >= 0) {
                    return false;
                }
            } else if (sign[i][index] > 0) {
                if (sum <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean go(int index) {
        if (index == n) {
            return true;
        }
        if (sign[index][index] == 0) {
            result[index] = 0;
            return check(index) && go(index + 1);
        }
        for (int i = 1; i <= 10; i++) {
            result[index] = sign[index][index]*i;
            if (check(index) && go(index + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        result = new int[n];
        sign = new int[n][n];

        String s = sc.next();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char x = s.charAt(cnt);
                if (x == '0') {
                    sign[i][j] = 0;
                } else if (x == '+') {
                    sign[i][j] = 1;
                } else {
                    sign[i][j] = -1;
                }
                cnt += 1;
            }
        }
        go(0);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
