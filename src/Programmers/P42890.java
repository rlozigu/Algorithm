package Programmers;

import java.util.*;

public class P42890 {
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"}
                              ,{"200","apeach","math","2"}
                              ,{"300","tube","computer","3"}
                              ,{"400","con","computer","4"}
                              ,{"500","muzi","music","3"}
                              ,{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }

    static boolean[] visited;
    static List<String> list = new ArrayList<>();

    static int solution(String[][] relation) {
        visited = new boolean[relation[0].length];

        for (int i = 0; i < relation[0].length; i++) {
            dfs(0, 0, i+1, relation);
        }

        return list.size();
    }

    static void dfs(int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> tmp_list = new ArrayList<>();
            String key = "";
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    tmp_list.add(i);
                }
            }

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < relation.length ; i++) {
                String s = "";
                for (Integer j:tmp_list) {
                    s += relation[i][j];
                }

                if (map.containsKey(s)) {
                    return;
                }else{
                    map.put(s, 0);
                }
            }

            for (String s : list) {
                int cnt = 0;
                for (int i = 0; i < key.length(); i++) {
                    String subs = String.valueOf(key.charAt(i));
                    if(s.contains(subs)) cnt++;
                }
                if(cnt == s.length()) return;
            }
            list.add(key);

            return;
        }

        for (int i = start; i < visited.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(i, depth+1, end, relation);
            visited[i] = false;
        }
    }
}
