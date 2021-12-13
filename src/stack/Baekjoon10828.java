package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];

        Stack stack = new Stack();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String fc = st.nextToken();

            switch (fc) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }


        }
    }
}

class Stack{
    int[] arr = new int[10000];
    int size = 0;

    public void push(int num){
        arr[size] = num;
        size++;
    }

    public int pop(){
        if(size == 0){
            return -1;
        }
        size--;
        int result = arr[size];
        arr[size] = 0;
        return result;
    }

    public int size(){
        return size;
    }

    public int empty(){
        return (size == 0)?1:0;
    }

    public int top(){
        return (size == 0)?-1:arr[size-1];
    }
}
