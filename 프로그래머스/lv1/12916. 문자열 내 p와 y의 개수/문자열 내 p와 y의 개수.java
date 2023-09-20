class Solution {
    boolean solution(String s) {
                boolean answer = true;
        String[] str = s.toLowerCase().split("");
        int p = 0;
        int y = 0;

        for (int i = 0; i < str.length; i++) {
            if ("p".equals(str[i])) {
                p++;
            } else if ("y".equals(str[i])) {
                y++;
            }
        }
        if (p != y) answer = false;

        return answer;
    }
}