package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14500 {
    static int[][][] block = {
            {{0,1}, {0,2}, {0,3}},
            {{1,0}, {2,0}, {3,0}},
            {{1,0}, {1,1}, {1,2}},
            {{0,1}, {1,0}, {2,0}},
            {{0,1}, {0,2}, {1,2}},
            {{1,0}, {2,0}, {2,-1}},
            {{0,1}, {0,2}, {-1,2}},
            {{1,0}, {2,0}, {2,1}},
            {{0,1}, {0,2}, {1,0}},
            {{0,1}, {1,1}, {2,1}},
            {{0,1}, {1,0}, {1,1}},
            {{0,1}, {-1,1}, {-1,2}},
            {{1,0}, {1,1}, {2,1}},
            {{0,1}, {1,1}, {1,2}},
            {{1,0}, {1,-1}, {2,-1}},
            {{0,1}, {0,2}, {-1,1}},
            {{0,1}, {0,2}, {1,1}},
            {{1,0}, {2,0}, {1,1}},
            {{1,0}, {2,0}, {1,-1}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 19; k++) {
                    boolean bool = true;
                    int sum = arr[i][j];

                    for (int l = 0; l < 3; l++) {
                        int x = i+block[k][l][0];
                        int y = j+block[k][l][1];

                        if(0 <= x && x < n && 0 <= y && y < m){
                            sum += arr[x][y];
                        }else{
                            bool = false;
                            break;
                        }
                    }

                    if (bool && result < sum) {
                        result = sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
