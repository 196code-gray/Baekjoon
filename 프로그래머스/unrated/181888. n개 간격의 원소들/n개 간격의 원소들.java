class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer;
        if (num_list.length % n == 0) {
            answer = new int[num_list.length / n];
        } else {
            answer = new int[num_list.length / n + 1];
        }
 
        int a = 0;
        for (int i = 0; i < num_list.length; i += n) {
            answer[a++] = num_list[i];
        }
        return answer;
    }
}