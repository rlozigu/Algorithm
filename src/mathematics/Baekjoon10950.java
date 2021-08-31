package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String ret = "";

        for(int i = 0 ; i < t ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ret += Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            ret += '\n';
        }

        System.out.println(ret);

    }
}
