package Programmers;

import java.util.LinkedList;

public class P17679 {
    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4, 5, board));
    }

    static int solution(int m, int n, String[] board) {
        LinkedList<Character>[] list = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList();
        }

        for (int j = m-1; j >= 0; j--) {
            String str = board[j];
            for (int i = 0; i < n; i++) {
                list[i].add(str.charAt(i));
            }
        }
        int answer = 0;

        Loop1:
        while (true){
            boolean[][] isEmpty = new boolean[n][m];
            int remove = 0;

            for (int i = 0; i < n - 1; i++) {
                System.out.println("i: " + i);
                for (int j = list[i].size() - 1; j > 0; j--) {
                    if(list[i+1].size() <= j) continue;
                    char tmp = list[i].get(j);
                    if(tmp == list[i].get(j-1)
                    && tmp == list[i+1].get(j-1)
                    && tmp == list[i+1].get(j)){
                        isEmpty[i][j] = isEmpty[i][j-1] = isEmpty[i+1][j-1] = isEmpty[i+1][j] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = list[i].size() - 1 ; j >= 0; j--) {
                    if (isEmpty[i][j]) {
                        System.out.println(list[i].get(j));
                        list[i].remove(j);
                        remove++;
                    }
                }
            }

            if (remove == 0) break Loop1;
            answer += remove;
        }

        return answer;
    }
}

