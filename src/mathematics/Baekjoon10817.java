package mathematics;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        for(int i = 0; i < arr.length ; i++){
            for(int j = 1; j < arr.length - i ; j++){
                int a = Integer.parseInt(arr[j-1]);
                int b = Integer.parseInt(arr[j]);
                int tmp = 0;

                if(a > b){
                    tmp = a;
                    arr[j-1] = b + "";
                    arr[j] = tmp + "";
                }
            }
        }

        System.out.println(arr[1]);
    }
}
