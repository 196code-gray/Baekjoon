import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int mod = 1_000_000_003;
        int n = Integer.parseInt(br.readLine()); int k = Integer.parseInt(br.readLine());
        if (n / 2 < k) {  // 구할 수 없는 경우
            System.out.println(0);
            return;
        }
        if (k == 1) { // 1가지 경우라면 n만큼 가능
            System.out.println(n);
            return;
        }
        int[][] dp = new int[n + 1][k + 1];
        dp[1][1] = 1; dp[2][1] = 2; dp[3][1]= 3;
        for (int i = 4; i <= n; i++){
            for (int j = 1; j <= k; j++){
                if (j == 1) dp[i][j] = i;
                else if (i % 2 == 0 && i / 2 == j) dp[i][j] = 2;
                else dp[i][j] = (dp[i -2][j -1] + dp[i-1][j]) % mod;
            }
        }
        System.out.println(dp[n][k] % mod);
    }
}