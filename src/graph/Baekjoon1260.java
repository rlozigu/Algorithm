package graph;

import java.util.*;

public class Baekjoon1260 {
    static List<Integer>[] arr;
    static boolean[] check;
    static String result = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        arr = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }

        dfs(v);
        result += "\n";
        check = new boolean[n + 1];
        bfs(v);
        System.out.println(result);
    }

    static void dfs(int node){
        check[node] = true;
        result += node + " ";

        for (int i = 0; i < arr[node].size(); i++) {
            int y = arr[node].get(i);

            if (!check[y]) {
                dfs(y);
            }
        }
    }

    static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        check[node] = true;

        while (!q.isEmpty()){
            int num = q.remove();
            result += num + " ";

            for (int i = 0; i < arr[num].size(); i++) {
                int num2 = arr[num].get(i);
                if(!check[num2]){
                    q.add(num2);
                    check[num2] = true;
                }
            }
        }
    }
}
