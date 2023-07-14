class Solution {
    public int solution(int n) {
        int answer = 2;
        boolean a = false;
        
        for (int i = 1; i <= n; i++) {
            if (i * i == n) {
                a = true;
                answer = 1;
        }
        }
        return answer;
    }
}
