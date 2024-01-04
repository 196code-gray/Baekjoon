import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n + 1][m + 1];
        int[][] candy = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= m; i++){
            dp[1][i] = dp[1][i -1] + candy[1][i];       // 1번째 줄은 초기값으로 candy의 오른쪽으로 간 부분만 먼저 dp에 저장
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++){
                // 현재 위치에서 위, 왼쪽, 왼쪽 대각선 값 중 제일 큰 값으로 저장
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + candy[i][j];
            }
        }
        System.out.println(dp[n][m]);
    }
}