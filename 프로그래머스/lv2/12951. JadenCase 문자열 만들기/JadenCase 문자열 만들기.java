class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            String ss = str[i];
            if (str[i].length() == 0) {
                answer += " ";
            } else {
                String first = str[i].substring(0, 1).toUpperCase();
                String a = str[i].substring(1, str[i].length()).toLowerCase();
                answer += first + a;
                answer += " ";
            }
        }
        if (s.substring(s.length() -1, s.length()).equals(" ")) return answer;
        return answer.substring(0, answer.length() -1);
    }
}