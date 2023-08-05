class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].charAt(0) == 'K') {
                if (seoul[i].charAt(1) == 'i') {
                    if (seoul[i].charAt(2) == 'm') {
                        answer = "김서방은 " + i + "에 있다";
                    }
                }
            }
        }
        return answer;
    }
}