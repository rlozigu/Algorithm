package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon10814 {
    public static void main(String[] args) throws IOException {
//        //1. Array.sort
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//
//        String[][] arr = new String[n][2];
//
//
//        for(int i = 0; i < n ; i++){
//            st = new StringTokenizer(br.readLine());
//            arr[i][0] = st.nextToken();
//            arr[i][1] = st.nextToken();
//        }
//
//        Arrays.sort(arr, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
//            }
//        });
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 0 ; i < n ; i++){
//            sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
//        }
//
//        System.out.println(sb);

        // 카운트정렬이용 풀이
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder [] sb = new StringBuilder [201];
        StringBuilder sbb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < sb.length ; i ++){
            sb[i] = new StringBuilder() ;
        }

        for (int i = 0 ; i < N ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            sb[age].append(age).append(" ").append(name).append("\n");
        }

        for (StringBuilder val : sb){
            sbb.append(val);
        }
        System.out.print(sbb);


    }
}
