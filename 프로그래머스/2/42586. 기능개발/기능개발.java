import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            double complete = ((100 - progresses[i]) / (double) speeds[i]);
            int day = (int) Math.ceil(complete);

            if (!q.isEmpty() && q.peek() < day) {
                list.add(q.size());
                q.clear();
            }
            q.offer(day);
        }
        list.add(q.size());
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}