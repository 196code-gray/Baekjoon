class Solution {
    public int solution(int price) {
        int answer = 0;
        if (price >= 500_000) {
            answer = (int) (price - (price * 0.2));
        }
        else if (price >= 300_000) {
            answer = (int) (price - (price * 0.1));
        }
        else if (price >= 100_000) {
            answer = (int) (price - (price * 0.05));
        }
        else answer = price;

        return answer;
    }
}