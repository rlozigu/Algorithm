package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0; j < n-i-1;j++){
                sb.append(" ");
            }
            if(i == n-1){
                for(int j = 0 ; j < n*2-1; j++){
                    sb.append("*");
                }
            }else{
                sb.append("*");
                for(int j = 0; j < i*2-1; j++ ){
                    sb.append(" ");
                }
                if(i != 0)
                sb.append("*");

            }

            sb.append("\n");
        }
            System.out.println(sb);
    }
}
