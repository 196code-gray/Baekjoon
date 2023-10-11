class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String num = String.valueOf(a) + String.valueOf(b);
        String two = String.valueOf(b) + String.valueOf(a);
        answer = Math.max(Integer.parseInt(num), Integer.parseInt(two));
        return answer;
    }
}