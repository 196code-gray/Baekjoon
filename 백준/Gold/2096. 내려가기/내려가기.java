import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[][] dp = new long[100_001][4];
        long[][] dp2 = new long[100_001][4];
        for (int i = 2; i<= n; i++){
            for (int j = 1; j <= 3; j++) dp2[i][j] = Integer.MAX_VALUE;
        }
        int[][] a = new int[100_001][4];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
                a[i][1] = Integer.parseInt(st.nextToken());
                a[i][2] = Integer.parseInt(st.nextToken());
                a[i][3] = Integer.parseInt(st.nextToken());
        }
        dp[1][1] = a[1][1]; dp[1][2] = a[1][2]; dp[1][3] = a[1][3];
        dp2[1][1] = a[1][1]; dp2[1][2] = a[1][2]; dp2[1][3] = a[1][3];
        for (int i = 2; i <= n; i++){
            dp[i][1] = Math.max(dp[i -1][1] + a[i][1], dp[i -1][2] + a[i][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + a[i][2], Math.max(dp[i - 1][2] + a[i][2], dp[i - 1][3] + a[i][2]));
            dp[i][3] = Math.max(dp[i -1][2] + a[i][3], dp[i -1][3] + a[i][3]);

            dp2[i][1] = Math.min(dp2[i -1][1] + a[i][1], dp2[i -1][2] + a[i][1]);
            dp2[i][2] = Math.min(dp2[i -1][1] + a[i][2], Math.min(dp2[i -1][2] + a[i][2], dp2[i -1][3] + a[i][2]));
            dp2[i][3] = Math.min(dp2[i -1][2] + a[i][3], dp2[i -1][3] + a[i][3]);
        }
        System.out.println(Math.max(dp[n][1], Math.max(dp[n][2], dp[n][3])) + " " + Math.min(dp2[n][1], Math.min(dp2[n][2], dp2[n][3])));
    }
}
