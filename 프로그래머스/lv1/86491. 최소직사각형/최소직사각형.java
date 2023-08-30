import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxResult = 0;
        int minResult = 0;
        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            maxResult = Math.max(maxResult, max);
            minResult = Math.max(minResult, min);

            answer = maxResult * minResult;
        }
        return answer;
    }
}