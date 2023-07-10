class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[end - start + 1];
        int i = 0;
        while (start <= end) {
            answer[i] = start;
            start++;
            i++;
        }
        
        return answer;
    }
}