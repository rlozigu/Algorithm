package graph;

import java.util.Scanner;
class Node{
    char left;
    char right;

    Node(char left, char right) {
        this.left = left;
        this.right = right;
    }
}
public class Baekjoon1991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] a = new Node[26];

        for (int i = 0; i < n; i++) {
            int x = sc.next().charAt(0) - 'A';
            char y = sc.next().charAt(0);
            char z = sc.next().charAt(0);

            char left = '0';
            char right = '0';
            if (y != '.') {
                left = y;
            }
            if (z != '.') {
                right = z;
            }
            a[x] = new Node(left, right);
        }
        preorder(a,'A');
        System.out.println();
        inorder(a,'A');
        System.out.println();
        postorder(a,'A');
        System.out.println();

    }

    static void preorder(Node[] a, char x) {
        if(x == '0') return;
        System.out.print(x);
        preorder(a, a[x-'A'].left);
        preorder(a, a[x-'A'].right);
    }
    static void inorder(Node[] a, char x) {
        if(x == '0') return;
        inorder(a, a[x-'A'].left);
        System.out.print(x);
        inorder(a, a[x-'A'].right);
    }
    static void postorder(Node[] a, char x) {
        if(x == '0') return;
        postorder(a, a[x-'A'].left);
        postorder(a, a[x-'A'].right);
        System.out.print(x);
    }
}
