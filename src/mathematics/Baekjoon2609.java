package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(getGcd(a, b));
        System.out.println(getLcm(a, b));

    }
    //재귀함수로 구현한 유클리드 호제법
    static int getGcd(int a, int b){
        if(b == 0){
            return a;
        }
        return getGcd(b, a%b);
    }

    //재귀함수를 사용하지 않고 구현한 유클리드 호제법
    static int getGcd2(int a, int b){
        while (b != 0) {
            int i = a % b;
            a = b;
            b = i;
        }
        return getGcd(b, a%b);
    }

    static int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }
}
