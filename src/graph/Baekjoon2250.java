package graph;

import java.util.Scanner;

class Node{
    int left;
    int right;
    int order;
    int depth;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
public class Baekjoon2250 {
    static Node[] a = new Node[10001];
    static int[] left = new int[10001];
    static int[] right = new int[10001];
    static int[] cnt = new int[10001];
    static int order = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            a[x] = new Node(y, z);
            if (y != -1) cnt[y]++;
            if (z != -1) cnt[z]++;
        }

        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                root = i;
            }
        }
        inorder(root, 1);
        int maxdepth = 0;
        for (int i = 1; i <= n; i++) {
            int depth = a[i].depth;
            int order = a[i].order;
            if (left[depth] == 0) {
                left[depth] = order;
            }else {
                left[depth] = Math.min(left[depth], order);
            }
            right[depth] = Math.max(right[depth], order);
            maxdepth = Math.max(maxdepth, depth);
        }

        int result = 0;
        int level = 0;
        for (int i = 1; i <= maxdepth; i++) {
            int tmp = right[i] - left[i] + 1;
            if (result < tmp) {
                result = tmp;
                level = i;
            }
        }

        System.out.println(level + " " + result);
    }

    static void inorder(int node, int depth) {
        if (node == -1) {
            return;
        }
        inorder(a[node].left, depth + 1);
        a[node].order = ++order;
        a[node].depth = depth;
        inorder(a[node].right, depth + 1);
    }
}
