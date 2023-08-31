import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1;
        long end = times[times.length -1] * (long) n;

        while (start <= end) {
            long a = 0;
            long mid = (start + end) / 2;
            for (int i = 0; i < times.length; i++) {
                a += mid / times[i];
            }
            if (a >= n) {
                end = mid -1;
                answer = mid;
            } else if (a < n) {
                start = mid + 1;
            } 
            // else {
            //     answer = mid;
            //     start = mid + 1;
            //     end = mid - 1;
            // }
        }
        return answer;
    }
}