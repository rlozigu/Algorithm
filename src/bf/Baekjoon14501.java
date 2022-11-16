package bf;

import java.util.Scanner;

public class Baekjoon14501 {
    static int[] t;
    static int[] p;
    static int n;
    static int result = 0;

    static void go(int day, int sum){
        if(day == n){
            result = Math.max(result, sum);
            return;
        }
        if (day > n) {
            return;
        }
        go(day+1, sum);
        go(day + t[day], sum + p[day]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        go(0, 0);
        System.out.println(result);
    }
}
