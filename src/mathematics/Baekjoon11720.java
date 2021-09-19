package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        char[] numbers = br.readLine().toCharArray();
        int result = 0;

        for(int i = 0 ; i < t ; i++){
            result += numbers[i] - '0';
        }

        System.out.println(result);
    }
}
