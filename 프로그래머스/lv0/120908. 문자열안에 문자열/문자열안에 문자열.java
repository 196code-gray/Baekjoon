class Solution {
    public int solution(String str1, String str2) {
        boolean result = str1.contains(str2);
        return result ? 1 : 2;
    }
}