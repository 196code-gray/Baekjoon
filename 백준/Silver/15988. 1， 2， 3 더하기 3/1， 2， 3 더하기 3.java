import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i <= 1_000_000; i ++){
            dp[i] = (dp[i -1] + dp[i -2] + dp[i -3]) % 1_000_000_009;
        }
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            int m = Integer.parseInt(br.readLine());
            sb.append(dp[m] % 1_000_000_009).append("\n");
        }
        System.out.println(sb);
    }
}