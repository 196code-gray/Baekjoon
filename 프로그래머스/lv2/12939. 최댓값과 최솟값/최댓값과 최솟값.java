import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            num.add(Integer.parseInt(str[i]));
        }
        answer += Collections.min(num) + " " + Collections.max(num);
        return answer;
    }
}