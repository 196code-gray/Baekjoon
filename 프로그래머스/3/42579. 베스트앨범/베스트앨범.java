import java.util.*;

class Solution {
public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, ArrayList<CD>> result = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<CD> l = result.getOrDefault(genres[i], new ArrayList<>());
            l.add(new CD(i, plays[i]));
            result.put(genres[i], l);
        }
        int[] answer = new int[map.size() * 2];

        int k = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Map.Entry<String, Integer>> maplist = new ArrayList<>(map.entrySet());
        Collections.sort(maplist, ((o1, o2) -> o2.getValue() - o1.getValue())); // 내림차순 정렬

        for (int i = 0; i < maplist.size(); i++) {
            String genre = maplist.get(i).getKey();
            ArrayList<CD> now = result.get(genre);
            Collections.sort(now, (o1, o2) -> {
                if (o2.count == o1.count) {
                    return o1.index - o2.index;
                } else {
                    return o2.count - o1.count;
                }
            });
             ans.add(now.get(0).index);
            if (now.size() > 1) ans.add(now.get(1).index);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    static class CD {
        int index;
        int count;

        public CD(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}