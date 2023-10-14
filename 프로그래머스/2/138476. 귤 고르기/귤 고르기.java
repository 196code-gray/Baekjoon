import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            if (!map.isEmpty() && map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        int[] num = new int[map.size()];
        int a = 0;
        for (int i : map.values()) {
            num[a] = i;
            a++;
        }
        Arrays.sort(num);
        for (int i = num.length -1; i >= 0; i--) {
            if (k <= 0) break;
            k -= num[i];
            answer++;
        }
        return answer;
    }
}