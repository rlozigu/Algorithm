package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2446 {
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        br.close();

        for(int i = n-1; i >= 0 ; i--) {
            for(int j = 1; j < n-i; j++)
                sb.append(" ");
            for(int j = 0; j < i*2+1; j++)
                sb.append("*");
            sb.append(NEW_LINE);
        }

        for(int i = 1; i < n ; i++) {
            for(int j = 1; j < n-i; j++)
                sb.append(" ");
            for(int j = 0; j < i*2+1; j++)
                sb.append("*");
            sb.append(NEW_LINE);
        }

        System.out.println(sb);
    }
}
