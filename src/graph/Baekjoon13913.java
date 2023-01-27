package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon13913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX = 100000;
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] check = new int[MAX + 1];
        for (int i = 0; i < MAX + 1; i++) {
            check[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = n;

        while (!q.isEmpty()) {
            int x = q.remove();

            if (x - 1 >= 0) {
                if (check[x - 1] == -1) {
                    q.add(x - 1);
                    check[x - 1] = x;
                }
            }

            if (x + 1 <= MAX) {
                if (check[x + 1] == -1) {
                    q.add(x + 1);
                    check[x + 1] = x;
                }
            }

            if (x * 2 <= MAX) {
                if (check[x * 2] == -1) {
                    q.add(x * 2);
                    check[x * 2] = x;
                }
            }
        }

        Stack<Integer> s = new Stack<>();
        for (int i = k; i != n ; i = check[i]) {
            s.push(i);
        }
        s.push(n);
        System.out.println(s.size() - 1);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
