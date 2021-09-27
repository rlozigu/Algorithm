package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjooon2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            for(int k = 0 ; k < i ; k++){
                sb.append(" ");
            }
            for(int j = n ; j > i ; j--){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
