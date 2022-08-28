package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] result = new int[n];
        int[] freq = new int[1000001];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq[arr[i]]++;
        }


        for (int i = 0; i < n; i++) {
            int num = arr[i];

            while (!stack.empty() && freq[arr[stack.peek()]] < freq[num]) {
                result[stack.pop()] = num;
            }

            stack.push(i);
        }

        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

    }
}
