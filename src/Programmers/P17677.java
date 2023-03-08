package Programmers;

import java.util.ArrayList;
import java.util.List;

public class P17677 {
    public static void main(String[] args) {
        System.out.println(solution("aa1+aa2", "AAAA12"));
    }

    static int solution(String str1, String str2) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        for (int i = 0; i < str1.length() - 0; i++) {
            String tmp = (str1 + " ").substring(i, i+2);
            if(tmp.matches("^[a-zA-Z]*$") && tmp.length() == 2){
                a.add(tmp.toLowerCase());
            }
        }
        for (int i = 0; i < str2.length() - 0; i++) {
            String tmp = (str2 + " ").substring(i, i+2);
            if(tmp.matches("^[a-zA-Z]*$") && tmp.length() == 2){
                b.add(tmp.toLowerCase());
            }
        }

        if (a.isEmpty() && b.isEmpty()) {
            return 65536;
        }

        List<String> inter = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for(String s : a){
            if(b.remove(s)){
                inter.add(s);
            }
            union.add(s);
        }

        union.addAll(b);

        double x = inter.size();
        double z = union.size();

        return (int)Math.floor(x/z * 65536);
    }
}
