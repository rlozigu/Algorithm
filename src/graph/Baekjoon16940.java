package graph;

import java.util.*;

public class Baekjoon16940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        int[] ints = new int[n+1];
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
            ints[i] = sc.nextInt();
            order[ints[i]] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            arr[i].sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (order[o1] < order[o2]) {
                        return -1;
                    } else if (order[o1] == order[o2]) {
                        return 0;
                    } else {
                        return 1;
                    }

                }
            });
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = true;
        ArrayList<Integer> bfsOrder = new ArrayList<>();

        while (!q.isEmpty()) {
            int x = q.remove();
            bfsOrder.add(x);
            for (int y : arr[x]) {
                if (!check[y]) {
                    check[y] = true;
                    q.add(y);
                }
            }
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (bfsOrder.get(i) != ints[i+1]) {
                ok = false;
            }
        }
        System.out.println(ok?1:0);
        }
}
