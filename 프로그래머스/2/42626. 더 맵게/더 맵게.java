import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int max = 0;
        for (int i : scoville) {
            q.offer(i);
            if (max < i) max = i;
        }
        if (max == 0) {
            return -1;
        }
        int now = q.peek();
        while (!q.isEmpty() && q.peek() < K) {
            if (q.size() > 1) {
                now = q.poll() + (q.poll() * 2);
                q.offer(now);
                answer++;
            } else now = q.poll();
        }
        if (now < K) return -1;
        else return answer;
    }
}