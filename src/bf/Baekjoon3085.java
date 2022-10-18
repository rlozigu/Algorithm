package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                //오른쪽 캔디와 교환
                char tmp = arr[i][j+1];
                arr[i][j+1] = arr[i][j];
                arr[i][j] = tmp;

                result = Math.max(result, check(arr));

                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = tmp;

                //아래쪽 캔디와 교환
                tmp = arr[j+1][i];
                arr[j+1][i] = arr[j][i];
                arr[j][i] = tmp;

                result = Math.max(result, check(arr));

                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = tmp;
            }
        }
        System.out.println(result);

    }

    static int check(char[][] arr){
        int len = arr.length;
        int result = 0;

        for (int i = 0; i < len; i++) {

            int cnt = 1;
            for (int j = 1; j < len; j++) {
                if(arr[i][j] == arr[i][j-1]){
                    cnt++;
                }else{
                    cnt = 1;
                }

                result = Math.max(result, cnt);
            }

            cnt = 1;
            for (int j = 1; j < len; j++) {
                if(arr[j][i] == arr[j-1][i]){
                    cnt++;
                }else{
                    cnt = 1;
                }

                result = Math.max(result, cnt);
            }
        }

        return result;
    }
}
