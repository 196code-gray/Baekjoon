import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (s.peek() != arr[i]) {
                s.push(arr[i]);
            }
        }
        int[] answer = new int[s.size()];

        Stack<Integer> result = new Stack<>();
        while(!s.isEmpty()) {
            result.push(s.pop());
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.pop();
        }
        return answer;
    }
}