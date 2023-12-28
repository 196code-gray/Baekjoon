class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1, 0};
        for (int i = 0; i < 4; i++){
            int nx = dx[i] + w;
            int ny = dy[i] + h;
            
            if (nx >= 0 && ny >= 0 && nx < board[0].length && ny < board.length && board[ny][nx].contentEquals(board[h][w])){
                answer++;
            }
        }
        return answer;
    }
}