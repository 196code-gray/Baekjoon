import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            Map<String, Map<String, Integer>> people = new HashMap<>(); // 본인이 선물 준 횟수
            Map<String, Integer> result = new HashMap<>();  // 선물 지수
            Map<String, Integer> ans = new HashMap<>();
            for (int i = 0; i < friends.length; i++){
                people.put(friends[i], new HashMap<>());
                result.put(friends[i], 0);
                ans.put(friends[i], 0);
            }
            for (int i = 0; i < friends.length; i++){
                Map<String, Integer> now = people.get(friends[i]);
                for (int j= 0; j < friends.length; j++){
                    if (i == j) continue;

                    now.put(friends[j], 0);
                }
            }

            for (int i= 0; i < gifts.length; i++){
                String[] s = gifts[i].split(" ");
                Map<String, Integer> now = people.get(s[0]);
                result.put(s[0], result.get(s[0]) + 1);
                result.put(s[1], result.get(s[1]) - 1);
                now.put(s[1], now.get(s[1]) + 1);
            }
            for (int i = 0; i < friends.length -1; i++){
                String me = friends[i];
                Map<String, Integer> now = people.get(me);
                for (int j = i + 1; j < friends.length; j++){
                    if (j == i) continue;
                    String friend = friends[j];
                    Map<String, Integer> next = people.get(friend);

                    if (now.get(friend) == next.get(me) || now.get(friend) == 0 && next.get(me) == 0){
                        if (result.get(me) == result.get(friend)) continue;
                        else if (result.get(me) > result.get(friend)) ans.put(me, ans.getOrDefault(me, 0) + 1);
                        else ans.put(friend, ans.getOrDefault(friend, 0) + 1);
                    }
                    else {
                        if (now.get(friend) > next.get(me)) ans.put(me, ans.getOrDefault(me, 0) + 1);
                        else ans.put(friend, ans.getOrDefault(friend, 0) + 1);
                    }
                }
            }
            for (String i : friends) {
                if (ans.get(i) > answer) answer = ans.get(i);
            }
            return answer;
        }
}