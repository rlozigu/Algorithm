package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2146 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] group = new int[n][n];
        int[][] d = new int[n][n];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int gn = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && group[i][j] == 0){
                    Queue<Integer> q = new LinkedList<>();
                    gn++;
                    q.add(i);
                    q.add(j);
                    group[i][j] = gn;

                    while (!q.isEmpty()) {
                        int x = q.remove();
                        int y = q.remove();

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (arr[nx][ny] == 1 && group[nx][ny] == 0) {
                                    q.add(nx);
                                    q.add(ny);
                                    group[nx][ny] = gn;
                                }
                            }
                        }
                    }
                }
            }
        }
        int result = -1;
        for (int l = 1; l <= gn; l++) {
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    d[j][k] = -1;
                    if (group[j][k] == l) {
                        q.add(j);
                        q.add(k);
                        d[j][k] = 0;
                    }
                }
            }

            while (!q.isEmpty()) {
                int x = q.remove();
                int y = q.remove();

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (d[nx][ny] == -1) {
                            d[nx][ny] = d[x][y] + 1;
                            q.add(nx);
                            q.add(ny);
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1 && group[i][j] != l) {
                        if (result == -1 || d[i][j] - 1 < result) {
                            result = d[i][j] - 1;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
