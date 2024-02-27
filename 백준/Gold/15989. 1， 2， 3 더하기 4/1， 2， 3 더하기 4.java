import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[10_001][4];
        dp[1][1] = 1; dp[2][1] =1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        // 미리 dp 값 구해놓기
        for (int i = 4; i<= 10_000; i++){
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i -2][2];
            dp[i][3] = dp[i -3][1]+dp[i - 3][2] + dp[i - 3][3];
        }
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }
        System.out.println(sb);
    }
}