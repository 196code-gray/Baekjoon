import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 0; i < skill.length; i++) {
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int de = skill[i][5];
            sum[r1][c1] += skill[i][0] == 1 ? -de : de;
            sum[r1][c2 + 1] += skill[i][0] == 1 ? de : -de;
            sum[r2 + 1][c1] += skill[i][0] == 1 ? de : -de;
            sum[r2 + 1][c2 + 1] += skill[i][0] == 1 ? -de : de;
        }
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += sum[i][j];
                ans = board[i][j] > 0 ? ans+=1 : ans;
            }
        }
        return ans;
    }
}