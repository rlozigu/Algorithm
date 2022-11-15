package bf;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1759 {
    static int l;
    static String[] arr;

    static void go(String password, int i){
        if (password.length() == l) {
            if(check(password)) System.out.println(password);
            return;
        }
        if(i >= arr.length) return;
        go(password + arr[i], i + 1);
        go(password, i + 1);
    }

    static boolean check(String password) {
        int ja = 0;
        int mo = 0;
        for (char c : password.toCharArray()) {
            if (c == 'a'
                    || c == 'e'
                    || c == 'i'
                    || c == 'o'
                    || c == 'u') {
                mo++;
            } else {
                ja++;
            }
        }
        return (ja >= 2 && mo >= 1)?true:false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        int c = sc.nextInt();

        arr = new String[c];
        for (int i = 0; i < c; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr);
        go("", 0);
    }
}
