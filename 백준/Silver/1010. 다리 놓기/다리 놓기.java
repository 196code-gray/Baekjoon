import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
            int dp[][] = new int[n + 1][m + 1];
            for (int i = 0; i <= m; i++) dp[1][i] = i;
            for (int i = 2; i <= n;i++){
                for (int j = i; j <= m; j++){
                    for (int k = j; k >= i; k--){
                        dp[i][j] += dp[i -1][k -1];
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}