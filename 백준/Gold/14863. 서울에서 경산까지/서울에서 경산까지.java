import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n + 1][k + 1];
        int[][] walk = new int[n + 1][2];
        int[][] bike = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            walk[i][0] = Integer.parseInt(st.nextToken());  // 걷는 시간
            walk[i][1] = Integer.parseInt(st.nextToken());  // 비용
            bike[i][0] = Integer.parseInt(st.nextToken());  // 자전거 시간
            bike[i][1] = Integer.parseInt(st.nextToken());  // 비용
        }

        dp[1][walk[1][0]] = walk[1][1];
        dp[1][bike[1][0]] = Math.max(dp[1][bike[1][0]],bike[1][1]);

        for (int i = 1; i <= n; i++) {       // 총 구간
            for (int j = 1; j <= k; j++) {    // 총 시간
                if (dp[i -1][j] != 0) {
                    
                    if (walk[i][0] + j <= k)
                        dp[i][walk[i][0] + j] = Math.max(dp[i][walk[i][0] + j], walk[i][1] + dp[i - 1][j]);
                if (bike[i][0] + j <= k)
                    dp[i][bike[i][0] + j] = Math.max(dp[i - 1][j] + bike[i][1], dp[i][bike[i][0] + j]);
                }
            }
       }
         int ans = 0;
        for (int i = 1; i <= k; i++) ans = Math.max(ans, (int) dp[n][i]);
        System.out.println(ans);
      
    }
}