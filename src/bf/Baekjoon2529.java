package bf;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon2529 {
    static char[] arr;
    static boolean[] check = new boolean[10];
    static ArrayList<String> result = new ArrayList<>();

    static void go(int index, String str) {
        if (index == arr.length + 1) {
            result.add(str);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (check[i]) continue;
            if (index == 0 || ok(str.charAt(index-1) - '0', i, arr[index-1])) {
                check[i] = true;
                go(index + 1, str + i );
                check[i] = false;
            }
        }
    }

    static boolean ok(int a, int b, char s){
        switch (s) {
            case '>':
                if (a > b) return true;
                break;
            case '<':
                if (a < b) return true;
                break;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        arr = new char[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.next().charAt(0);
        }

        go(0, "");
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }
}
