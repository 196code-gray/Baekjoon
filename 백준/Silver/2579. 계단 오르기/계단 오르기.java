import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        for (int i = 1; i <= n; i++){
                dp[i][0] = Math.max(dp[i -1][1], dp[i -1][2]);
                dp[i][1] = dp[i -1][0] + arr[i];
                dp[i][2] = dp[i -1][1] + arr[i];
                ans = Math.max(dp[i][1], dp[i][2]);
            }
        System.out.println(ans);
        }
    }