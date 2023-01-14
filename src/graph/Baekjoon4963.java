package graph;

import java.util.Scanner;

public class Baekjoon4963 {
    static int[][] map;
    static boolean[][] visit;

    static int w;
    static int h;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {1, 0, -1, -1, 1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            sc.nextLine();

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(visit[i][j] || map[i][j] == 0) continue;
                    dfs(i, j);
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < h && 0 <= ny && ny < w){
                if ((!visit[nx][ny]) && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
