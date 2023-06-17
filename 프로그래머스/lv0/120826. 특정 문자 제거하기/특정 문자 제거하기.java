class Solution {
    public String solution(String my_string, String letter) {
        String answer = my_string;
        for (int i= 0; i < my_string.length(); i++) {
            if (letter.charAt(0) == my_string.charAt(i)) {
                answer = answer.replace(letter, "");
            }
        }
        return answer;
    }
}