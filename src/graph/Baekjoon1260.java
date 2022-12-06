package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon1260 {
    static int n;
    static boolean[] check;
    static boolean[][] arr;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        arr = new boolean[n+1][n+1];
        check = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = true;
            arr[b][a] = true;
        }

        dfs(v);
        System.out.println();
        check = new boolean[n+1];
        bfs(v);

    }

    static void dfs(int x){
        check[x] = true;
        System.out.print(x + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[x][i] && !check[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int x){
        check[x] = true;
        q.add(x);
        System.out.print(x + " ");

        while (!q.isEmpty()) {
            int y = q.peek();
            q.remove();
            for (int i = 1; i <= n; i++) {
                if (arr[y][i] && !check[i]) {
                    check[i] = true;
                    q.add(i);
                    System.out.print(i +  " ");
                }
            }
        }
    }
}
