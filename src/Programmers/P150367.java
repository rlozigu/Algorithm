package Programmers;

public class P150367 {
    public static void main(String[] args) {
        long[] numbers = {7, 42, 5};
        solution(numbers);
    }

    static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String num = Long.toBinaryString(numbers[i]);

            int d = 0;
            while((int)Math.pow(2, d)-1 < num.length()){
                d++;
            }
            while((int)Math.pow(2, d) - 1 != num.length()){
                num = "0" + num;
            }

            if(dfs(num)){
                answer[i] = 1;
            }
        }
        return answer;
    }

    static boolean dfs(String num){
        if(num.length() < 3){
            return true;
        }

        int mid = (num.length()-1)/2;
        char root = num.charAt(mid);
        String left = num.substring(0, mid);
        String right = num.substring(mid+1, num.length());

        if(root == '0' && (left.charAt((left.length()-1)/2) == '1' || right.charAt((right.length()-1)/2) == '1')){
            return false;
        }

        return dfs(left) && dfs(right);
    }
}
