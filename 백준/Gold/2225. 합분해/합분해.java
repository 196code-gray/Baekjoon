import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        long[][] dp = new long[k + 1][n + 1];
        for (int i= 1;i<=k;i++){
            for (int j = 0; j <= n; j++){
                if (j == 0) dp[i][j] = 1;
                else dp[i][j] = (dp[i -1][j] + dp[i][j -1]) % 1_000_000_000;
            }
        }
        System.out.println(dp[k][n] % 1_000_000_000);
 }}
