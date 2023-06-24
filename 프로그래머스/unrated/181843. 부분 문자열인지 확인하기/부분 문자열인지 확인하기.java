class Solution {
    public int solution(String my_string, String target) {
        int answer = 0;
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.contains(target)) answer = 1;
        }
        return answer;
    }
}