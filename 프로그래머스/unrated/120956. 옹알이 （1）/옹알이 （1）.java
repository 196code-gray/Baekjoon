class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] s = {"aya", "ye", "woo", "ma"};
        for (String i : babbling) {
            for (String j : s) {
                if (i.contains(j)) {
                    i = i.replace(j, "*");
                }
            }
            String a = "^\\*+$$";
            if (i.matches(a)) {
                answer++;
            }
        }
        return answer;
    }
}