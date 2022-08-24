package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '<'){

                if(tmp.length() != 0){
                    result.append(tmp.reverse());
                    tmp.delete(0, tmp.length());
                }

                result.append(ch);
                while(true){
                    char temp = str.charAt(++i);
                    result.append(temp);

                    if (temp == '>') {
                        break;
                    }
                }
            } else if (ch == ' ') {
                result.append(tmp.reverse()).append(' ');
                tmp.delete(0, tmp.length());
            } else {
                tmp.append(ch);
            }
        }

        if(tmp.length() != 0){
            result.append(tmp.reverse());
            tmp.delete(0, tmp.length());
        }

        System.out.println(result);
    }
}
