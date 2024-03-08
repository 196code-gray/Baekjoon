import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[][] dp = new int[4][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken()) + arr[i -1];
        int k = Integer.parseInt(br.readLine()); // 최대 객차

        for (int i = 1; i <= 3; i++){
            for (int j = i * k; j <= n; j++){
                dp[i][j] = Math.max(dp[i][j -1], dp[i -1][j - k] + (arr[j] - arr[j - k]));
            }
        }
        System.out.println(dp[3][n]);
    }
}