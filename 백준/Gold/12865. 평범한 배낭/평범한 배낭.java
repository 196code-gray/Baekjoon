import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int[] kg = new int[n + 1]; int[] v = new int[n+ 1];
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1;i <= n; i++){
            st = new StringTokenizer(br.readLine());
            kg[i] = Integer.parseInt(st.nextToken());   // 무게
            v[i] = Integer.parseInt(st.nextToken());    // 가치
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= k; j++){
                if (j - kg[i] >= 0){
                    dp[i][j] = Math.max(dp[i -1][j], dp[i-1][j - kg[i]] + v[i]);
                }
                else dp[i][j] = dp[i -1][j];
            }
        }
        System.out.println(dp[n][k]);
    }
}