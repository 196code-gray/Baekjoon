class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String f = "";
        String t = "";
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 != 0) {
                f += String.valueOf(num_list[i]);
            } else {
                t += String.valueOf(num_list[i]);
            }
        }
        answer = Integer.parseInt(f) + Integer.parseInt(t);
        return answer;
    }
}