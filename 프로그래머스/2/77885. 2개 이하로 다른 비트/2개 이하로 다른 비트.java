import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int n;
        long now;
        long temp;

        for (int i = 0; i < numbers.length; i++) {
            now = numbers[i];
            temp = now;
            n = 0;

            while (temp > 0) {
                if (temp % 2 == 0) {
                    break;
                }
                temp /= 2;
                n++;
            }

            if (n == 0) {
                now++;
            } else {
                now = now + (long) Math.pow(2, n) - (long) Math.pow(2, n - 1);
            }
            answer[i] = now;
        }

        return answer;
    }
}