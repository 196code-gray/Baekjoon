import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int count = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] + count <= budget) {
                count += d[i];
                answer++;
            }
        }
        return answer;
    }
}