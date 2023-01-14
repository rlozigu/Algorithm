package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2178 {
    static int[][] maze;
    static int[][] visit;

    static int n;
    static int m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        maze = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0, 1);
        System.out.println(visit[n-1][m-1]);
    }
    static void bfs(int x, int y, int num){
        Queue<Pair> q = new LinkedList<>();
        visit[x][y] = num;
        q.add(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (visit[nx][ny] == 0 && maze[nx][ny] == 1) {
                        visit[nx][ny] = visit[p.x][p.y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}

class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
