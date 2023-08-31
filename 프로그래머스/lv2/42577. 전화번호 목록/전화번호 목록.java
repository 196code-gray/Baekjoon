import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
                boolean answer = true;
        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], true);
        }

        for (int i = 0; i < phone_book.length; i++) {
            String s = "";
            for (int j = 0; j < phone_book[i].length() -1; j++) {
                String str = String.valueOf(phone_book[i].charAt(j));
                s += str;
                if (map.containsKey(s)) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}