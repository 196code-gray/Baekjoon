import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coin = new int[n + 1];
            for (int i = 1;i <= n; i++) coin[i] = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(br.readLine());
            long[] dp = new long[k + 1];

            dp[0]++;
            for (int i = 1; i <= n; i++){
               
                for (int j = coin[i]; j <= k; j++){
                    dp[j] += dp[j - coin[i]];
                }
            }
            System.out.println(dp[k]);
        }
    }
}