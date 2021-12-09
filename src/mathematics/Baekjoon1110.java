package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int org = n;
        int result = 0;

        while(true){
            result++;
            int a = n/10;
            int b = n%10;

            n = (b*10) + (a+b)%10;

            if(org == n){
                break;
            }

        }
        System.out.println(result);
    }

}
