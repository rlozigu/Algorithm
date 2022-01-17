package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            String str = br.readLine();
            int result = 0;
            int num = 0;

            for (byte value : br.readLine().getBytes()) {

                if (value == 'O') {
                    num++;
                    result += num;
                }
                else {
                    num = 0;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
