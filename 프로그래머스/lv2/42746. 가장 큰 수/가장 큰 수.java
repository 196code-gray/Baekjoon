import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String numStr = String.valueOf(numbers[i]);
            str[i] = numStr.repeat(3);
        }
        Arrays.sort(str, Collections.reverseOrder());
        
        if (str[0].equals("000")) {
           return "0";
        }

        for (int i = 0; i < str.length; i++) {
            int len = str[i].length() / 3;
            answer += str[i].substring(0, len);
        }
        return answer;
    }
}