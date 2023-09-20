import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
                String answer = "Yes";

        Queue<String> str1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> str2 = new LinkedList<>(Arrays.asList(cards2));

        for (int i = 0; i < goal.length; i++) {
            if (!str1.isEmpty() && goal[i].contentEquals(str1.peek())) {
                str1.poll();
            } else if (!str2.isEmpty() && goal[i].contentEquals(str2.peek())) {
                str2.poll();
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}