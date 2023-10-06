class Solution {
    public int solution(int n) {
        int answer = 1;
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (count == n) {
                    answer++;
                    count = 0;
                    break;
                } else if (count > n) {
                    count = 0; break;
                }
                else count += j;
            }
        }
        return answer;
    }
}