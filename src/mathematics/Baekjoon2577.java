package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int result[] = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int mul = a * b * c;

        while(mul != 0){
            result[mul%10]++;
            mul/=10;
        }

        for(int i = 0 ; i < result.length; i++){
            sb.append(result[i]);
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
