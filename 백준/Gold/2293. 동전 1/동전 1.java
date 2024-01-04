import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        long[] dp = new long[k + 1];
        int[] coin = new int[n + 1];
        for (int i = 1; i <= n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++){
                dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}