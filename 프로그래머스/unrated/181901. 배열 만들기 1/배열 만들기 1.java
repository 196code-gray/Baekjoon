import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        int[] answer =  new int[n+k];
        for (int i = 1; i <= n; i++) {
            if (i % k == 0) {
                answer[i] = i;
            }
        }
        answer = Arrays.stream(answer).filter(a -> a != 0).sorted().toArray();
        return answer;
    }
}