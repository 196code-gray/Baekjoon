import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] dp = new long[n +1][m + 1];
        int[][] water = new int[n + 1][m + 1];
        dp[0][1] = 1;
        for (int[] i : puddles){
            water[i[1]][i[0]] = -1;
        }
        for (int i =1; i <= n; i++){
            for (int j= 1; j <= m; j++){
                if (water[i][j] == -1) continue;
                else dp[i][j] = (dp[i -1][j] + dp[i][j -1]) % 1_000_000_007;
            }
        }
        return (int) dp[n][m] % 1_000_000_007;
    }
}