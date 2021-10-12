package dp;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(recur(26));
    }

    public static int recur(int num){
        if(num == 1){
            return 1;
        }
        if(num == 2){
            return 1;
        }
        int result = recur(num-1) + recur(num-2);
        return result;
    }
}
