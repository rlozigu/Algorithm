package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack left = new Stack();
        Stack right = new Stack();

        String str = br.readLine();
        for (char c : str.toCharArray()) {
            left.push(c);
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "L":
                    if(left.empty()) break;
                    right.push(left.pop());
                    break;
                case "D":
                    if(right.empty()) break;
                    left.push(right.pop());
                    break;
                case "B":
                    if(left.empty()) break;
                    left.pop();
                    break;
                case "P":
                    left.push(st.nextToken());
                    break;
            }
        }

        while (!left.empty()) {
            right.push(left.pop());
        }

        while (!right.empty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}

