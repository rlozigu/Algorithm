package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        final int MAX = 100001;

        int[] check = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            check[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> next = new LinkedList<>();

        q.add(n);
        check[n] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            if (x * 2 < MAX) {
                if (check[x * 2] == -1) {
                    q.add(x * 2);
                    check[x * 2] = check[x];
                }
            }
            if (x + 1 < MAX) {
                if (check[x + 1] == -1) {
                    next.add(x + 1);
                    check[x+1] = check[x] + 1;
                }
            }
            if (x - 1 >= 0) {
                if (check[x - 1] == -1) {
                    next.add(x - 1);
                    check[x-1] = check[x] + 1;
                }
            }

            if (q.isEmpty()) {
                q = next;
                next = new LinkedList<>();
            }
        }
        System.out.println(check[k]);
    }
}
