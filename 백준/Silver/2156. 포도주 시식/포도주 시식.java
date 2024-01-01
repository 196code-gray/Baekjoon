import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+ 1][3];
        int[] arr = new int[n+ 1];
        for (int i =1; i <=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1){
            System.out.println(arr[n]);
            return;
        }
        if (n==2){
            System.out.println(arr[n] + arr[n -1]);
            return;
        }
        dp[1][1] = arr[1]; dp[2][0] = dp[1][1]; dp[2][1] = dp[1][0] + arr[2]; dp[2][2] = dp[1][1] + arr[2];
        for (int i = 3; i <= n; i++){
            dp[i][0] = Math.max(dp[i -1][1], Math.max(dp[i -1][2], dp[i -1][0]));
            dp[i][1] = dp[i-1][0] + arr[i];
            dp[i][2] = dp[i -1][1] + arr[i];
        }
        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }
}