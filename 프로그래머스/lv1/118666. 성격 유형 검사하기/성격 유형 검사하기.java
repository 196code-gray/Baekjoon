import java.util.*;
class Solution {
        public static String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Integer, Integer> map = Map.of(
                1, 3,
                2, 2,
                3, 1,
                4, 0,
                5, 1,
                6, 2,
                7, 3
        );
        Map<String, Integer> str = new HashMap<>();
                str.put("R", 0);
                str.put("T", 0);
                str.put("C", 0);
                str.put("F" ,0);
                str.put("J", 0);
                str.put("M", 0);
                str.put("A", 0);
                str.put("N", 0);
        String name = "";

        for (int i = 0; i < survey.length; i++) {
            int score = map.get(choices[i]);
            if (choices[i] <= 3) {
                name = String.valueOf(survey[i].charAt(0));
                str.put(name, score + str.get(name));
            } else if (choices[i] >= 5) {
                name = String.valueOf(survey[i].charAt(1));
                str.put(name, score + str.get(name));
            }
        }
        answer += (str.get("R") >= str.get("T")) ? "R" : "T";
        answer += (str.get("C") >= str.get("F")) ? "C" : "F";
        answer += (str.get("J") >= str.get("M")) ? "J" : "M";
        answer += (str.get("A") >= str.get("N")) ? "A" : "N";

        return answer;
    }
}