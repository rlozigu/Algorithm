package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon7562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[][] visit;

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};


        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            visit = new int[l][l];

            for (int u = 0 ; u < l ; u++) {
                Arrays.fill(visit[u],-1);
            }

            int x = sc.nextInt();
            int y = sc.nextInt();

            int ax = sc.nextInt();
            int ay = sc.nextInt();

            if (x == ax && y == ay) {
                System.out.println(0);
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(x);
            q.add(y);
            visit[x][y] = 0;

            loop1:
            while (!q.isEmpty()) {
                int xx = q.remove();
                int yy = q.remove();

                for (int j = 0; j < 8; j++) {
                    int nx = xx + dx[j];
                    int ny = yy + dy[j];
                    if (nx == ax && ny == ay) {
                        System.out.println(visit[xx][yy] + 1);
                        break loop1;
                    }

                    if (0 <= nx && nx < l && 0 <= ny && ny < l) {
                        if (visit[nx][ny] == -1) {
                            q.add(nx);
                            q.add(ny);
                            visit[nx][ny] = visit[xx][yy] + 1;
                        }
                    }
                }
            }

        }
    }
}