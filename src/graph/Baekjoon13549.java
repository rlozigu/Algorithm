package graph;

import java.util.ArrayDeque;
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

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n);
        check[n] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x * 2 < MAX) {
                if (check[x * 2] == -1) {
                    q.addFirst(x * 2);
                    check[x * 2] = check[x];
                }
            }
            if (x + 1 < MAX) {
                if (check[x + 1] == -1) {
                    q.addLast(x + 1);
                    check[x+1] = check[x] + 1;
                }
            }
            if (x - 1 >= 0) {
                if (check[x - 1] == -1) {
                    q.addLast(x - 1);
                    check[x-1] = check[x] + 1;
                }
            }
        }
        System.out.println(check[k]);
    }
}
