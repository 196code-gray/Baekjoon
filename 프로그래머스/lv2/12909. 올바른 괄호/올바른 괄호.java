import java.util.*;
class Solution {
    boolean solution(String s) {

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        Stack<Character> stack = new Stack<>(); 
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(s.charAt(i));
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}