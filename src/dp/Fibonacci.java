package dp;

public class Fibonacci {
    static int[] dp = new int[100];

    public static void main(String[] args) {
        System.out.println(fibo(26));
    }

    public static int fibo(int num) {
        //첫번재 수열인 경우
        if (num == 1) {
            return 1;
        }
        //두번째 수열인 경우
        if (num == 2) {
            return 1;
        }
        //배열에 저장된 값이 있을 시 저장된 값 반환
        if (dp[num] != 0) {
            return dp[num];
        }
        //저장된 값이 없는 경우, 값을 저장 후 반환
        return dp[num] = fibo(num - 1) + fibo(num - 2);
    }
}