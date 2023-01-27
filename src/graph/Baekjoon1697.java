package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX = 100000;
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] check = new int[100001];
        for (int i = 0; i < 100001; i++) {
            check[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = 0;

        while (!q.isEmpty()) {
            int x = q.remove();
            if (x - 1 >= 0) {
                if (check[x - 1] == -1) {
                    q.add(x - 1);
                    check[x - 1] = check[x] + 1;
                }
            }

            if (x + 1 <= MAX) {
                if (check[x + 1] == -1) {
                    q.add(x + 1);
                    check[x + 1] = check[x] + 1;
                }
            }

            if (x * 2 <= MAX) {
                if (check[x * 2] == -1) {
                    q.add(x * 2);
                    check[x * 2] = check[x] + 1;
                }
            }
        }

        System.out.println(check[k]);
    }
}
