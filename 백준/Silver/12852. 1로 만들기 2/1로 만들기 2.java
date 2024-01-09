import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1){
            System.out.println(0);
            System.out.println("1");
            return;
        }
        long[] dp = new long[1_000_001];
        int[] arr = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i<=n; i++){
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                arr[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1){
                dp[i] = dp[i/3] + 1;
                arr[i] = i / 3;
            }

            if (dp[i] > dp[i -1] + 1) {
                dp[i] = Math.min(dp[i -1] + 1, dp[i]);
                arr[i] = i -1;
            }
        }

        System.out.println(dp[n]);
        // 경로 출력
        while (n > 0){
            sb.append(n).append(" ");
            n = arr[n];
        }
        System.out.println(sb);
    }
}