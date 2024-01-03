import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][n+1];
        int[] left = new int[n +1];
        int[] right = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = n; i > 0; i--) left[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = n; i > 0; i--) right[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = Math.max(dp[i -1][j -1], dp[i -1][j]);
                if (left[i] > right[j]) dp[i][j] = Math.max(dp[i][j], dp[i][j -1] + right[j]);
            }
        }
        System.out.println(dp[n][n]);
    }
}