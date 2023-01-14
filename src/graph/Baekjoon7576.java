package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon7576 {
    static int[][] box;
    static int[][] check;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        box = new int[n][m];
        check = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = -1;
                if (box[i][j] == 1) {
                    q.add(new Pair(i, j));
                    check[i][j] = 0;
                }
            }
        }

        int result = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (check[nx][ny] == -1 && box[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        check[nx][ny] = check[p.x][p.y] + 1;
                        result = check[nx][ny];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] != -1 && check[i][j] == -1){
                    System.out.println(-1);
                    System.exit(0);
                };
            }
        }

        System.out.println(result);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
