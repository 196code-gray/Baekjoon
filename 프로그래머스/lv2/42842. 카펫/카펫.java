class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for (int i = 3; i < total; i++){
            if(total % i == 0){
                int a = total / i;
                int b = i;
                
                int row = Math.max(a, b);
                int col = Math.min(a, b);
                
                if ((row - 2) * (col - 2) == yellow){
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        
        return answer;
    }
}