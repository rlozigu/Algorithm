package Programmers;

import java.util.*;

public class P42888 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }

    static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<History> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);

            String act = st.nextToken();
            String uid = st.nextToken();
            if (st.hasMoreTokens()) {
                String name = st.nextToken();
                map.put(uid, name);
            }
            if("Change".equals(act)) continue;
            list.add(new History(uid, act));
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = map.get(list.get(i).uid) + "님이 "
                        + ("Enter".equals(list.get(i).act)?"들어왔습니다.":"나갔습니다.");
            System.out.println(answer[i]);
        }

        return answer;
    }

    static class History{
        String uid;
        String act;

        public History(String uid, String act) {
            this.uid = uid;
            this.act = act;
        }
    }
}
