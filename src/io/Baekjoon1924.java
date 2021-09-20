package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1924 {
    public static void main(String[] args) throws IOException {
        int dayMax[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String week[] = {"SUN", "MON","TUE","WED","THU","FRI","SAT"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());


        for(int i=1;i<month;i++) {
            day += dayMax[i];
        }

        String result = week[day%7];
        System.out.println(result);

        }
}
