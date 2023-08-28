import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> idMap = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], 0);
            reportMap.put(id_list[i], new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            if (!reportMap.get(str[0]).contains(str[1])) {
                idMap.put(str[1], idMap.get(str[1]) + 1);
            }
            reportMap.get(str[0]).add(str[1]);
        }

        for (int i = 0; i < id_list.length; i++) {
            String a = id_list[i];
            int count = 0;
            for (String name : reportMap.get(a)) {
                if (idMap.get(name) >= k) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}