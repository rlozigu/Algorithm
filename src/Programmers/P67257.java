package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P67257 {
    static char[] top = {'-', '*', '+'};
    static long answer;

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }

    static long solution(String expression) {
        for (String s:expression.split("[-*+]")
             ) {
            System.out.println(s);
        }
        ArrayList<Long> n_list = (ArrayList<Long>)Arrays.stream(expression.split("[-*+]")).mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
        ArrayList<Character> c_list = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '-' || ch == '*' || ch == '+'){
                c_list.add(ch);
            }
        }

        perm(n_list, c_list, 0);
        return answer;
    }

    static void perm(ArrayList<Long> n_list, ArrayList<Character> c_list, int depth){
        if(depth == 3){
            long temp = Calculate((ArrayList<Long>)n_list.clone(), (ArrayList<Character>)c_list.clone());
            if(temp > answer)
                answer = temp;
            return ;
        }

        for (int i = depth; i < 3; i++) {
            swap(i, depth);
            perm(n_list, c_list,depth + 1);
            swap(i, depth);
        }
    }

    static void swap(int a, int b){
        char k = top[a];
        top[a] = top[b];
        top[b] = k;
    }

    static long Calculate(ArrayList<Long> n_list, ArrayList<Character> c_list) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < c_list.size(); j++) {
                if(c_list.get(j) == top[i]) {
                    switch(top[i]) {
                        case '-':
                            n_list.add(j, n_list.remove(j) - n_list.remove(j));
                            break;
                        case '*':
                            n_list.add(j, n_list.remove(j) * n_list.remove(j));
                            break;
                        case '+':
                            n_list.add(j, n_list.remove(j) + n_list.remove(j));
                            break;
                    }
                    c_list.remove(j--);
                }
            }
        }
        return Math.abs(n_list.get(0));
    }
}
