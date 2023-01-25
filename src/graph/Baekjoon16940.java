package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon16940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        int[] parent = new int[n+1];
        int[] order = new int[n+1];
        boolean[] check = new boolean[n+1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList();
        }

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            order[i] = sc.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = true;

        int m = 1;//큐의 크기
        for (int i = 1; i <= n; i++) {
            if (q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }
            int x = q.remove();
            if (x != order[i]) {
                System.out.println(0);
                System.exit(0);
            }
            int cnt = 0;
            for (int y : arr[x]) {
                if (!check[y]) {
                    parent[y] = x;
                    cnt++;
                }
            }
            for (int j = 1; j <= cnt; j++) {
                if (m + j > n || parent[order[m + j]] != x) {
                    System.out.println(0);
                    System.exit(0);
                }
                q.add(order[m + j]);
                check[order[m + j]] = true;
            }
            m += cnt;
        }
        System.out.println(1);
    }
}
