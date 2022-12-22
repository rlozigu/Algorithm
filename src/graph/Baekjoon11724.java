package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon11724 {
    static boolean[] checked;
    static ArrayList<Integer>[] g;
    static Queue<Integer> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        checked = new boolean[n + 1];

        g = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            g[num1].add(num2);
            g[num2].add(num1);
        }

        q = new LinkedList<>();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if(checked[i]) continue;
            result++;
            bfs(i);
        }

        System.out.println(result);
    }

    static void bfs(int i) {
        checked[i] = true;
        q.add(i);

        while (!q.isEmpty()){
            int t = q.remove();
            for (int k = 0; k < g[t].size(); k++) {
                if(checked[g[t].get(k)]) continue;
                bfs(g[t].get(k));
            }
        }

    }
}
