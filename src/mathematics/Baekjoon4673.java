package mathematics;

public class Baekjoon4673 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        //결과값을 담을 배열
        boolean[] arr = new boolean[10001];

        for(int i = 0; i <= 10000; i++){
            int result = d(i);

            //결과값의 배열값을 true로 바꿔준다.
            if(result < 10001){
                arr[result] = true;
            }
        }
        for (int i = 1; i < arr.length; i++){
            if(!arr[i]){
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);

    }

    //d(n)을 구하는 함수
    public static int d(int n){
        int result = n;

        while(n > 0){
            result += n%10;
            n /= 10;
        }

        return result;
    }
}
