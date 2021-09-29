package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n-1 ; i++){
            for(int j = 0; j < i; j++){
                sb.append("*");
            }
            for(int j = 0; j < 2*n-i*2; j++){
                sb.append(" ");
            }
            for(int j = 0; j < i; j++){
                sb.append("*");
            }

            sb.append("\n");
        }
        for(int i = 0 ; i < n*2; i++){
            sb.append("*");
        }
            sb.append("\n");
        for(int i = n-1; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                sb.append("*");
            }
            for(int j = 0; j < 2*n-i*2; j++){
                sb.append(" ");
            }
            for(int j = 0; j < i; j++){
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
