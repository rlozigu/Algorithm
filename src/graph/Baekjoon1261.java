package graph;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon1261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        int[][] maze = new int[n][m];
        int[][] check = new int[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
                check[i][j] = -1;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(0);
        q.add(0);
        check[0][0] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (check[nx][ny] == -1) {
                        if (maze[nx][ny] == 0) {
                            check[nx][ny] = check[x][y];
                            q.addFirst(ny);
                            q.addFirst(nx);
                        }
                        if (maze[nx][ny] == 1) {
                            check[nx][ny] = check[x][y] + 1;
                            q.addLast(nx);
                            q.addLast(ny);
                        }
                    }
                }
            }
        }

        System.out.println(check[n-1][m-1]);
    }
}
