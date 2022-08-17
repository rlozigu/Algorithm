package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack();

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val > start) {
                for (int j = start + 1; j <= val; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                //다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
                start = val;
            } else if (stack.peek() < val) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
