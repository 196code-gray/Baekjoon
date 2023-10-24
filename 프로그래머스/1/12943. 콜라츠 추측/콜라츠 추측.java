class Solution {
    public int solution(int num) {
        long answer = 0;
        long n = num;
        if (n == 1) return 0;
        while(n != 1) {
            if (answer > 500) {
                answer = -1;
                break;
            }
            else if (n % 2 == 0) {
                n /= 2;
                answer++;
            }
            else {
                n = (n * 3) + 1;
                answer++;
            }
        }
        return (int) answer;
    }
}