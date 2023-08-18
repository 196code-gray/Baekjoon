class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];
        int a = 0;
        for (int i = start; i >= 0; i--) {
            answer[a] = i;
            if (a == start - end)  break;
                else a++;

        }
        return answer;
    }
}