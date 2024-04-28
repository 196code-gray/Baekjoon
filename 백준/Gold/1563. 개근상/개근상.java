import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int mod = 1_000_000;

        int[][][] dp = new int[1001][2][3]; // n일에 지각을 0,1 했을 경우 결석을 0,1,2 회 했을 경우
        dp[1][0][0] = dp[1][0][1] = dp[1][1][0] = 1; // 1일차에 지각 x, 결석 x + 지각 x, 결석 1 + 지각 1, 결석 0 경우

        for (int i = 2; i<= n;i++){
            dp[i][0][0] = (dp[i -1][0][0] + dp[i -1][0][1] + dp[i -1][0][2]) % mod;
            dp[i][0][1] = (dp[i -1][0][0]) % mod;
            dp[i][0][2] = (dp[i -1][0][1]) % mod;
            dp[i][1][0] = (dp[i -1][0][0] + dp[i -1][0][1] + dp[i -1][0][2] + dp[i -1][1][0] + dp[i -1][1][1] + dp[i -1][1][2]) % mod;
            dp[i][1][1] = (dp[i -1][1][0]) % mod;
            dp[i][1][2] = (dp[i -1][1][1]) % mod;
        }
        System.out.println((dp[n][0][0] + dp[n][0][1] + dp[n][0][2] + dp[n][1][0] + dp[n][1][1] + dp[n][1][2]) % mod);
    }
}