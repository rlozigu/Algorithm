package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        boolean[] check = new boolean[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = true;

        while (!q.isEmpty()) {
            int x = q.remove();

            for (int a: arr[x]) {
                if(!check[a]){
                    check[a] = true;
                    q.add(a);
                    parent[a] = x;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
