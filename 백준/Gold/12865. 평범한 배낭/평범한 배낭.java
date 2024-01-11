import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int[][] w = new int[n + 1][2]; long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i ++){
            st = new StringTokenizer(br.readLine());
            w[i][0] = Integer.parseInt(st.nextToken());
            w[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= k; j++){
                if (j - w[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i][0]] + w[i][1]);
                }
                else dp[i][j] = dp[i -1][j];
            }
        }
        System.out.println(dp[n][k]);
    }}