package Programmers;

import java.util.ArrayList;
import java.util.List;

public class P17683 {
    public static void main(String[] args) {
        String m = "ABdgffdC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }

    static String solution(String m, String[] musicinfos) {
        String answer = "";
        int length = 0;

        m = m.replaceAll("C#", "0");
        m = m.replaceAll("D#", "1");
        m = m.replaceAll("F#", "2");
        m = m.replaceAll("G#", "3");
        m = m.replaceAll("A#", "4");

        for (int i = 0; i < musicinfos.length; i++) {
            String[] arr = musicinfos[i].split(",");
            int s = Integer.parseInt(arr[0].split(":")[0]) * 60 + Integer.parseInt(arr[0].split(":")[1]);
            int e = Integer.parseInt(arr[1].split(":")[0]) * 60 + Integer.parseInt(arr[1].split(":")[1]);
            if(e == 0) e = 1440;
            int len = e - s;

            String title = arr[2];
            String str = arr[3];
            str = str.replaceAll("C#", "0");
            str = str.replaceAll("D#", "1");
            str = str.replaceAll("F#", "2");
            str = str.replaceAll("G#", "3");
            str = str.replaceAll("A#", "4");

            while (str.length() < len){
                str += str;
            }
            str = str.substring(0, len);
            System.out.println(str);


            if (str.contains(m) && len > length) {
                answer = title;
                length = len;
            }
        }
        return ("".equals(answer))?"(None)":answer;
    }
}



