package Programmers;

import java.util.Stack;

public class P60058 {
    public static void main(String[] args) {
        System.out.println(solution("))()(("));
    }

    static String solution(String p) {
        if ("".equals(p)) {
            return "";
        }

        if (isRight(p)) {
            return p;
        }

        int left_cnt = 0;
        int right_cnt = 0;
        Stack<String> stack = new Stack<>();
        int idx = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left_cnt++;
            } else {
                right_cnt++;
            }

            if(left_cnt == right_cnt){
                stack.push((p+" ").substring(idx, i + 1));
                idx = i+1;
                left_cnt = right_cnt = 0;
            }
        }
        System.out.println(stack);
        String pre = "";
        while (!stack.isEmpty()) {
            System.out.println(pre);
            String str = stack.pop();
            if ("".equals(str) || isRight(str)){
                pre = str + pre;
                continue;
            }

            pre = "(" + pre + ")" + correctStr(str);
        }

        return pre;
    }

    static boolean isRight(String s){
        Stack<Integer> left = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(1);
            } else {
                if (left.isEmpty()) return false;
                left.pop();
            }
        }

        return left.isEmpty();
    }

    static String correctStr(String str) {
        String result  = "";
        str = str.substring(1, str.length()-1);
        System.out.println(str + "!@@@@@");
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                result += ")";
            }else{
                result += "(";
            }
        }
        System.out.println(result);
        return result ;
    }
}
