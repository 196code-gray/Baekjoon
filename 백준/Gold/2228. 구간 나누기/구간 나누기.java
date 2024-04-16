import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][m + 1];
        int[] sum = new int[n + 1]; // 누적합 배열

        for (int i = 1; i <= n; i++){
            sum[i] = Integer.parseInt(br.readLine()) + sum[i -1];
        }
        for (int i = 1; i <= m; i++) dp[0][i] = -3276900;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = dp[i -1][j];
                for (int k = 1; k <= i; k++){
                    if (k >= 2){ // 구간을 나눌 수 있을 경우
                        dp[i][j] = Math.max(dp[k -2][j - 1] + sum[i] - sum[k -1], dp[i][j]);
                    }
                    else if (k == 1 && j == 1) dp[i][j] = Math.max(dp[i][j], sum[i]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}