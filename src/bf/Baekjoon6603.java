package bf;

import java.util.*;

public class Baekjoon6603 {
    static boolean nextPermutation(int[] a){
        int i = a.length - 1;
        while (i > 0 && a[i] <= a[i - 1]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] <= a[i-1]){
            j--;
        }

        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;

        j = a.length - 1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i ++;
            j --;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                if (i < n - 6) {
                    d[i] = 0;
                }else{
                    d[i] = 1;
                }
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            do {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (d[i] == 1) {
                        cur.add(a[i]);
                    }
                }
                result.add(cur);
            } while (nextPermutation(d));
            Collections.sort(result, new Comparator<ArrayList<Integer>>() {

                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int n = o1.size();
                    int m = o2.size();
                    int i = 0;
                    while (i < n && i < m) {
                        int t1 = o1.get(i);
                        int t2 = o2.get(i);
                        if(t1 < t2) return -1;
                        else if (t1 > t2) return 1;
                        i++;
                    }
                    if(i == n && i != m) return -1;
                    else if (i != n && i == m) return 1;
                    return 0;
                }
            });
            for (ArrayList<Integer> v : result) {
                for (int x : v) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
