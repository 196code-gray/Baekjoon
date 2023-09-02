import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
                Queue<Integer> q = new LinkedList<>();


        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else q.add((100 - progresses[i]) / speeds[i] + 1);
        }

        List<Integer> a = new ArrayList<>();
        int day = 1;
        int i = 0;
        int num = q.poll();
        while (!q.isEmpty()) {
            if (num >= q.peek()) {
                day++;
                q.poll();
            } else {
                a.add(day);
//                answer[i] = day;
                i++;
                day = 1;
                num = q.poll();
            }
        } a.add(day);
//        answer[i] = day;
        int[] answer = new int[a.size()];
        for (int j = 0; j < answer.length; j++) {
            answer[j] = a.get(j);
        }

        return answer;
    }
}