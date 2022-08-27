package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];

        stack.add(0);

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];


            while (!stack.empty()) {
                if(arr[stack.peek()] >= num){
                    break;
                }

                nge[stack.pop()] = num;
            }

            stack.push(i);
        }

        while (!stack.empty()) {
            nge[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            sb.append(nge[i]).append(" ");
        }

        System.out.println(sb);
    }
}
