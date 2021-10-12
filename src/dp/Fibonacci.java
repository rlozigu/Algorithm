package dp;

public class Fibonacci {
    static int[] dp = new int[100];

    public static void main(String[] args) {
        System.out.println(fibo(26));
    }

    public static int fibo(int num){
        //첫번째, 두번째 수열에 1 저장
        dp[0] = 1;
        dp[1] = 1;

        //반복문을 돌며 3번째 수열부터 차례로 값을 채워넣는다
        for(int i = 2; i < num; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num - 1];
    }
}