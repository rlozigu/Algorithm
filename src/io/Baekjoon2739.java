package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2739 {
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= 9 ; i++){
            sb.append(num).append(" * ").append(i).append(" = ")
                    .append(num * i).append(NEW_LINE);
        }

        System.out.println(sb);
    }
}
