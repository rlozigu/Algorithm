package Programmers;

import java.util.Arrays;
import java.util.Comparator;
public class P17686 {
    public static void main(String[] args) {
        solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
    }
    static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = detach(o1);
                String[] file2 = detach(o2);

                int head = file1[0].compareTo(file2[0]);

                if (head == 0) {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return num1 - num2;
                } else {
                    return head;
                }
            }

            private String[] detach(String str) {
                String head = "";
                String number = "";
                String tail = "";

                int idx = 0;
                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    if(ch >= '0' && ch <= '9') break;
                    head += ch;
                }

                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    if(!(ch >= '0' && ch <= '9')) break;
                    number += ch;
                }

                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    tail += ch;
                }

                String[] file = {head.toLowerCase(), number, tail};

                return file;
            }
        });

        return files;
    }
}
