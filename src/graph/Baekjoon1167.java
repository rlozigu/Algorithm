package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1167 {
    public static ArrayList<Edge>[] arr;
    public static int v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        arr = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            int x = sc.nextInt();
            int y;
            while ((y = sc.nextInt()) != -1) {
                int z = sc.nextInt();
                arr[x].add(new Edge(y, z));
            }
        }

        int[] a = bfs(1);
        int max = 0;
        for (int i = 1; i <= v; i++) {
           if(a[i] > a[max]){
               max = i;
           };
        }

        a = bfs(max);
        max = 0;
        for (int i = 1; i <= v; i++) {
            if(a[i] > a[max]){
                max = i;
            };
        }

        System.out.println(a[max]);
    }

    static int[] bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        int[] result = new int[v+1];
        for (int i = 0; i <= v; i++) {
            result[i] = -1;
        }
        result[node] = 0;

        while (!q.isEmpty()) {
            int x = q.remove();

            for (Edge e: arr[x]) {
                int nx = e.to;
                int ny = e.cost;

                if (result[nx] == -1) {
                    q.add(nx);
                    result[nx] = result[x] + ny;
                }
            }
        }
        return result;
    }
}

class Edge {
    public int to;
    public int cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
