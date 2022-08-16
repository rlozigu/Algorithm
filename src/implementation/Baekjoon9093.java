package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()){
                String str = st.nextToken();

                //StringBuilder을 이용해 풀기
                sb.append(new StringBuilder(str).reverse()).append(" ");

/*
                스택을 이용해 풀기
                Stack stack = new Stack();

                for (int j = 0; j < str.length(); j++) {
                    stack.push(str.charAt(j));
                }
                for (int j = 0; j < str.length(); j++) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
*/

/*              스택 없이 for문을 이용해 풀기
                for(int j = str.length() ; j > 0 ; j--){
                   sb.append(str.charAt(j-1));
                }
                sb.append(" ");*/

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
