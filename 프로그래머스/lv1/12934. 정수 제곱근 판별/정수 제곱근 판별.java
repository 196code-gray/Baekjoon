class Solution {
    public long solution(long n) {
        long answer = 0;
            for (long i = 1; i <= Math.sqrt(n); i++) {
            if (Math.pow(i, 2) == n) answer = (long) Math.pow(i + 1, 2);
            else answer = -1;
        }
            return answer;
    }
}