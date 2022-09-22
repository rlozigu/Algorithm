package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int r = str.length() % 3;

        switch (r) {
            case 1:
                sb.append(str.charAt(0));
                break;
            case 2:
                sb.append((str.charAt(0) - '0') * 2 + str.charAt(1) - '0');
                break;
        }

        for(int i = r; i < str.length(); i+=3){
            sb.append((str.charAt(i) - '0') * 4
                    + (str.charAt(i + 1) - '0') * 2
                    + (str.charAt(i + 2) - '0'));
        }

        System.out.println(sb);
    }
}
