package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1107 {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        if (t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < t; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        //숫자키 입력 x하는 경우
        int result = n - 100;
        if (result < 0) {
            result = -result;
        }

        for (int i = 0; i <= 1000000; i++) {
            int a = i;
            int len = possible(a);

            if (len > 0) {
                int press = a - n;
                if (press < 0) {
                    press = -press;
                }
                if (result > len + press) {
                    result = len + press;
                }
            }
        }
        System.out.println(result);
    }

    static int possible(int num){
        if(num == 0){
            return broken[0] ? 0 : 1;
        }

        int len = 0;
        while (num > 0) {
            if(broken[num % 10]) return 0;
            len += 1;
            num /= 10;
        }
        return len;
    }
}
