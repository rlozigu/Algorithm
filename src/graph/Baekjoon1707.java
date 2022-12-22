package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon1707 {
    static int[] checked;
    static ArrayList<Integer>[] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int v = sc.nextInt();
            int e = sc.nextInt();

            checked = new int[v+1];
            g = new ArrayList[v+1];

            for (int j = 1; j <= v; j++) {
                g[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < e; j++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();

                g[num1].add(num2);
                g[num2].add(num1);
            }

            boolean result = true;
            for (int j = 1; j <= v; j++) {
                if (checked[j] == 0) {
                    if(!dfs(j, 1)) result = false;
                }
            }

            System.out.println(result?"YES":"NO");
        }
    }

    static boolean dfs(int node, int c) {
        checked[node] = c;
        for (int i = 0; i < g[node].size(); i++) {
            int next = g[node].get(i);
            if(checked[next] == 0){
                if(dfs(next, 3 - c) == false){
                    return false;
                }
            } else if (checked[node] == checked[next]) {
                return false;
            }
        }
        return true;
    }
}
