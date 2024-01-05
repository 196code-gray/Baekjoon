class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[500][500];
        for (int i = triangle.length -1; i > triangle.length -2; i--){
            for (int j = 0; j <= triangle[i].length -1; j++){
                dp[i][j] = triangle[i][j];
            }
        }
        for (int i = triangle.length -1; i > 0; i--){
            for (int j = 0; j <= triangle[i].length-1; j++){
                if (j == 0) {
                    dp[i-1][j]= Math.max(dp[i -1][j], dp[i][j] + triangle[i-1][j]);
                } else if (j == triangle[i].length -1) {
                    dp[i-1][j-1] = Math.max(dp[i-1][j-1], dp[i][j] + triangle[i -1][j -1]);
                } else {
                    dp[i - 1][j - 1] = Math.max(dp[i - 1][j - 1], dp[i][j] + triangle[i - 1][j - 1]);
                    dp[i - 1][j] = Math.max(dp[i - 1][j + 1], dp[i][j] + triangle[i - 1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);
        return dp[0][0];
    }
}