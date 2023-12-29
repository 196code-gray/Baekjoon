class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer, dBox, pick;
        answer = dBox = pick = 0;

        for (int i = n -1; i >= 0; i--){
            if (deliveries[i] > 0 || pickups[i] > 0){
                dBox -= deliveries[i];
                pick -= pickups[i];
                if (dBox < 0 || pick < 0){
                    long count = Math.max((-dBox - 1) / cap + 1, (-pick - 1) / cap + 1);
                    answer += count * (i + 1) * 2L;
                    dBox += count * cap;
                    pick += count * cap;
                }
            }
        }
        return answer;
    }
}