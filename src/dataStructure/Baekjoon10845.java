package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue queue = new Queue();
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    queue.pop();
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.empty();
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
            }
        }

    }
}

class Queue{
    int[] arr = new int[10000];
    int begin = 0;
    int end = 0;

    void push(int x){
        arr[end] = x;
        end++;
    }

    void pop(){
        if (end == begin){
            System.out.println(-1);
        }else{
            System.out.println(arr[begin++]);
        }
    }

    void size(){
        System.out.println(end - begin);
    }

    void empty(){
        System.out.println((begin == end) ? 1 : 0);
    }

    void front(){
        System.out.println((begin == end) ? -1 : arr[begin]);
    }

    void back(){
        System.out.println((begin == end) ? -1 : arr[end - 1]);
    }
}
