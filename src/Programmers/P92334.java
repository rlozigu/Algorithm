package Programmers;

import java.util.*;
import java.util.stream.IntStream;

public class P92334 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] result = solution(id_list, report, k);
        for (int x :
                result) {
            System.out.print(x + " ");
        }
    }

    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,Integer> suspendedList = new HashMap<>();
        HashMap<String,Integer> idIdx = new HashMap<>();

        int idx = 0;

        //1. 유저 정보 세팅
        for (int i = 0; i < id_list.length; i++) {
            idIdx.put(id_list[i], i);
            users.add(new User(id_list[i]));
        }

        //2. 신고받기
        for(String s : report){
            String[] arr = s.split(" ");
            users.get(idIdx.get(arr[0])).reportList.add(arr[1]);
            users.get(idIdx.get(arr[1])).reportedList.add(arr[0]);
        }

        //3. 정지 유저 리스트 만들기
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }

        //4. 정답도출
        for(User user : users){
            for(String nameReport : user.reportList){
                if(suspendedList.get(nameReport) != null){
                    answer[idIdx.get(user.name)]++;
                }

            }
        }

        return answer;
    }
}

class User{
    String name;
    HashSet<String> reportList;
    HashSet<String> reportedList;
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}

