package mathematics;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

       for(int i = 0 ; i < t; i++){
            String str = br.readLine();
            int target = str.indexOf(" ");
            int a = Integer.parseInt(str.substring(0, target));
            int b = Integer.parseInt(str.substring(target + 1));

            bw.write(a+b+" ");
            bw.write("\n");
        }

        br.close();

        bw.flush();
        bw.close();

    }
}
