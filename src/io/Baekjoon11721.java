package io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        for(int i=0; i<n; i=i+10) {
            if (i + 10 > n) {
                System.out.println(str.substring(i, n));
            } else {
                System.out.println(str.substring(i, i + 10));
            }
        }

    }
}
