import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static long[][][] dp = new long[33][33][3];
    static int[][] home = new int[33][33];
    static int n;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j= 1; j <= n; j++){
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][2][0] = 1;

        for (int i = 1; i <= n; i++){
            for (int j = 3; j <= n; j++){
                if (home[i][j] == 1) continue;

                // 가로
                dp[i][j][0] = dp[i][j -1][0] + dp[i][j -1][2];
                if (i == 1) continue; // 첫행은 반드시 가로만 가능
                // 세로
                dp[i][j][1] = dp[i -1][j][1] + dp[i -1][j][2];
                if (home[i -1][j] == 1 || home[i][j -1] == 1) continue; // 대각선의 경우 현재 위치가 아닌 전행 || 전열까지 
                // 대각선(오아대)
                dp[i][j][2] = dp[i -1][j -1][0] + dp[i -1][j -1][1] + dp[i -1][j -1][2];
            }
        }

        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}