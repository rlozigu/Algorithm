package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int burger = Integer.MAX_VALUE;
        int soda = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(br.readLine());
            burger = Math.min(burger, num);
        }

        for (int i = 0; i < 2; i++) {
            int num = Integer.parseInt(br.readLine());
            soda = Math.min(num, soda);
        }

        System.out.println(burger + soda - 50);


    }
}
