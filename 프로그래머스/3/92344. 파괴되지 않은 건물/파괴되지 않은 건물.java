class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int num = skill[i][5];
            sum[r1][c1] += ((type) == 1) ? -num : +num;
            sum[r1][c2 + 1] += ((type) == 1) ? +num : -num;
            sum[r2 + 1][c1] += ((type) == 1) ? +num : -num;
            sum[r2 + 1][c2 + 1] += ((type) == 1) ? -num : +num;
        }
        arraySum(sum);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] += sum[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
    static void arraySum(int[][] sum){
        for (int i = 0; i < sum[0].length -1; i++){
            for (int j = 1; j < sum.length -1; j++){
                sum[j][i] += sum[j -1][i];
            }
        }
        for (int i = 0; i < sum.length -1; i++){
            for (int j= 1; j < sum[0].length -1; j++){
                sum[i][j] += sum[i][j -1];
            }
        }
    }
}