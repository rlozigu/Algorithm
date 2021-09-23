package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n ; i++){
            for(int j = n ; j > i ; j--){
                sb.append(" ");
            }
            for(int k = 0; k < i ; k++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
