package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = "";

        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
        }

    }
}
