import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i + 1);
        }
        for (int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]);
            String name = players[rank -2]; // 전 선수 이름

            map.put(name, rank);
            map.put(callings[i], rank -1);
            players[rank -1] = name;
            players[rank -2] = callings[i];
        }

        return players;
    }
}