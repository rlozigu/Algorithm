package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon16964 {

    static int n;
    static ArrayList<Integer>[] arr;
    static int[] ints;
    static int[] order;
    static boolean[] check;
    static ArrayList<Integer> dfsOrder = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new ArrayList[n+1];
        ints = new int[n+1];
        order = new int[n+1];
        check = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            ints[i] = sc.nextInt();
            order[ints[i]] = i;
        }

        for (int i = 1; i < n+1; i++) {
            arr[i].sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(order[o1] < order[o2]){
                        return -1;
                    } else if (order[o1] == order[o2]) {
                        return 0;
                    }else {
                        return 1;
                    }
                }
            });
        }

        dfs(1);
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (dfsOrder.get(i) != ints[i + 1]) {
                ok = false;
            }
        }

        System.out.println(ok?1:0);
    }

    static void dfs(int node){
        check[node] = true;
        dfsOrder.add(node);

        for (int i = 0; i < arr[node].size() ; i++) {
            int x = arr[node].get(i);
            if (!check[x]){
                dfs(x);
            }
        }
    }
}
