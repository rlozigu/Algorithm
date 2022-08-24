package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        int result = 0;

        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);

            switch (ch) {
                case '(':
                    cnt++;
                    break;
                case ')':
                    cnt--;

                    //레이저
                    if(str.charAt(i-1) == '('){
                        result += cnt;
                    }else{
                        result++;
                    }
                    break;
            }
        }
        System.out.println(result);

    }
}
