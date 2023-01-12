package graph;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2667 {
    static int[][] map;
    static int[][] visit;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        map = new int[n][n];
        visit = new int[n][n];
        int num = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && visit[i][j] == 0){
                    dfs(i, j, ++num);
                }
            }
        }

        int[] result = new int[num];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num1 = visit[i][j] - 1;
                if (num1 >= 0) {
                    result[num1]++;
                }
            }
        }

        Arrays.sort(result);

        System.out.println(num);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static void dfs(int x, int y, int num) {
        visit[x][y] = num;

        for (int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];

            if (0 <= nx && nx < n && 0 <= ny && ny < n ){
                if (map[nx][ny] == 1 && visit[nx][ny] == 0) {
                    dfs(nx, ny, num);
                }
            }
        }
    }
}
