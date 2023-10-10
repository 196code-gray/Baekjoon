class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String[] str = str2.split(str1);
        if (str.length == 0 || str2.length() != str[0].length()) answer = 1;
        return answer;
    }
}