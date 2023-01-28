package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        final int MAX = 1001;
        int[][] check = new int[MAX][MAX];

        for (int i = 0; i < MAX; i++) {
            Arrays.fill(check[i], -1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(0);
        check[1][0] = 0;

        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();

            if (check[x][x] == -1) {
                check[x][x] = check[x][y] + 1;
                q.add(x);
                q.add(x);
            }

            if (x + y < MAX && check[x + y][y] == -1) {
                check[x + y][y] = check[x][y] + 1;
                q.add(x+y);
                q.add(y);
            }

            if (x - 1 >= 0 && check[x - 1][y] == -1) {
                check[x - 1][y] = check[x][y] + 1;
                q.add(x-1);
                q.add(y);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < MAX; i++) {
            if (check[s][i] != -1) {
                result = Math.min(result, check[s][i]);
            }
        }
        System.out.println(result);
    }
}
