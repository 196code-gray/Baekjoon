import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] arr = new int[n +1];
        int[] dp = new int[n +1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i= 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i < n; i++){
            for (int j = 1; j <= arr[i]; j++){
                if (j + i <= n) dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        System.out.println((dp[n] < 0 || dp[n] == Integer.MAX_VALUE) ? -1 : dp[n]);
    }
}