package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long count5 = five_power_n(a) - five_power_n(a - b) - five_power_n(b);
        long count2 = two_power_n(a) - two_power_n(a - b) - two_power_n(b);

        System.out.println(Math.min(count5, count2));

    }

    static long five_power_n(long num) {
        int count = 0;

        while (num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    static long two_power_n(long num) {
        int count = 0;

        while (num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }
}
