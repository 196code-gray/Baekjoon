class Solution {
    public String solution(String my_string) {
        String answer = my_string;
        String[] minus = {"a", "e", "i", "o", "u"};
        for (int i = 0; i < minus.length; i++) {
            if (my_string.contains(minus[i])) {
                answer = my_string.replaceAll(minus[i], "");
                my_string = answer;
            } else answer = my_string;
        }
        return answer;
    }
}