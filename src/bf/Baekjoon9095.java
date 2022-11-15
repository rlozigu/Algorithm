package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9095 {
    static int go(int sum, int goal){
        if(sum > goal) return 0;
        if(sum == goal) return 1;

        int result = 0;
        result += go(sum + 1, goal);
        result += go(sum + 2, goal);
        result += go(sum + 3, goal);
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int result = go(0, n);

            System.out.println(result);
        }
    }
}
