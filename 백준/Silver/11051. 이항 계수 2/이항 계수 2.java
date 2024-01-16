import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i ++){
            for (int j = 0; j <= i; j++){
                if (j == 0) dp[i][0] = 1;
                else dp[i][j] = (dp[i -1][j] + dp[i -1][j -1]) % 10007;
            }
        }
        System.out.println(dp[n][k] % 10007);
    }}