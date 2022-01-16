package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] scores = new double[n];

        for(int i = 0 ; i < n ; i++){
            scores[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(scores);
        double sum = 0;

        for(int i = 0; i < n; i++){
            sum += scores[i]/scores[n-1]*100;
        }
        System.out.println(sum/n);

    }
}
