package bf;

import java.util.*;

public class Baekjoon14889 {
    static int[][] arr;
    static Stack<Integer> first = new Stack<>();
    static Stack<Integer> second = new Stack<>();

    static int go(int index) {
        int n = arr.length;

        if (index == arr.length) {
            if(first.size() != n/2) return -1;
            if(second.size() != n/2) return -1;

            int result1 = 0;
            int result2 = 0;

            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n/2; j++) {
                    if(i == j)continue;
                    result1 += arr[first.get(i)][first.get(j)];
                    result2 += arr[second.get(i)][second.get(j)];
                }
            }
            return Math.abs(result1 - result2);
        }

        if(first.size() > n/2) return -1;
        if(second.size() > n/2) return -1;

        int result = -1;
        first.push(index);
        int t1 = go(index + 1);
        if (result == -1 || (t1 != -1 && result > t1)) {
            result = t1;
        }
        first.pop();
        second.push(index);
        int t2 = go(index + 1);
        if (result == -1 || (t2 != -1 && result > t2)) {
            result = t2;
        }
        second.pop();

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(go(0));
    }
}
