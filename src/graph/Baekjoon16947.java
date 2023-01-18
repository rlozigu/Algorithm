package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon16947 {
    static ArrayList<Integer>[] arr;
    static int[] check;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new ArrayList[n];
        dist = new int[n];
        check = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt() -1;
            int b = sc.nextInt() -1;

            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(0, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 2) {
                dist[i] = 0;
                q.add(i);
            } else {
                dist[i] = -1;
            }
        }

        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : arr[x]) {
                if (dist[y] == -1) {
                    q.add(y);
                    dist[y] = dist[x] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static int dfs(int x, int p) {
        // -2: 사이클 찾음, 포함되지 않음
        // -1: 사이클 못 찾음
        // 0~n-1: 사이클 찾음, 시작 인덱스
        if (check[x] == 1) {
            return x;
        }
        check[x] =1;
        for (int y : arr[x]) {
            if (y == p) continue;
            int result = dfs(y, x);
            if (result == -2) {
                return -2;
            }
            if (result >= 0) {
                check[x] = 2;
                if (x == result) {
                    return -2;
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
