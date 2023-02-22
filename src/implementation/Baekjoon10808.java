package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int[] result = new int[26];

        for (char ch:arr) {
            result[ch - 97]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i:result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
