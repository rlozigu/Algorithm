package graph;

import java.util.Scanner;

public class Baekjoon16929 {
    static int n;
    static int m;
    static char[][] arr;
    static boolean[][] check;
    static int[][] dist;

    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        arr = new char[n][m];
        check = new boolean[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j]) continue;
                if (dfs(i, j, 1)) {
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }

        System.out.println("No");
    }

    static boolean dfs(int x, int y, int cnt) {
        if (check[x][y]) {
            if (cnt-dist[x][y] >= 4) {
                return true;
            } else {
                return false;
            }
        }

        check[x][y] = true;
        dist[x][y] = cnt;

        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (arr[nx][ny] == arr[x][y]) {
                    if (dfs(nx, ny, cnt+1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
