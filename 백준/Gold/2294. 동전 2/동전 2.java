import java.io.*;
import java.util.*;

public class Main {
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][k +1]; int[] coin = new int[n + 1];
        int INF = 10_000_000;

        for (int i = 1; i<= n;i++){
            coin[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], INF);
        }
        Arrays.fill(dp[0], INF);

        for (int i = 1; i<= n; i++){
            dp[i][0] = 1;
            if(k >= coin[i]) dp[i][coin[i]] = 1;
            for (int j = 1; j <= k; j++){
                if (j - coin[i] >= 0){
                    dp[i][j] = Math.min(dp[i][j - coin[i]] + 1, Math.min(dp[i -1][j], dp[i][j]));
                    if (dp[i][j-coin[i]] !=INF) dp[i][j]=Math.min(dp[i][j],dp[i][j-1] + 1);
                }
                else dp[i][j] = dp[i -1][j];
            }
        }

        System.out.println((dp[n][k] == INF) ? -1 : dp[n][k]);
    }
}