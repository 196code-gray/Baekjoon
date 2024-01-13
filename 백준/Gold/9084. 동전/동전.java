import java.util.*;
import java.io.*;

class Main{
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t --> 0){
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[21];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[10001];
            dp[0] = 1;
            int m = Integer.parseInt(br.readLine());
            sb.append(dp(coin, m, n)).append("\n");
        }
        System.out.println(sb);
    }
    static int dp(int[] coin, int m, int n){
        for (int i = 1; i <= n; i++){
            for (int j = coin[i]; j <= m; j++){
                dp[j] += dp[j - coin[i]];
            }
        }
        return dp[m];
    }
}