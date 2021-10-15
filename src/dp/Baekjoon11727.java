package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n+1];

        System.out.println(recur(d, n));
        br.close();
    }

    public static int recur(int[] d, int num){
        if(num == 0 || num == 1){
            return 1;
        }

        if(d[num] == 0){
            d[num] = (recur(d,num-2) * 2 + recur(d,num-1)) % 10007;
        }

        return d[num];
    }
}
