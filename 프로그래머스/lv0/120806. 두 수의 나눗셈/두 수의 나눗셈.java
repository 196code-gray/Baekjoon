class Solution {
    public int solution(int num1, int num2) {
        double answer = (double) num1 / num2;
        answer *= 1000;
        int result = (int) answer;
        return result;
    }
}