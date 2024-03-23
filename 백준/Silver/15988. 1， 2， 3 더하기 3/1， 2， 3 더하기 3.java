import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_002];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i<= 1_000_000; i++){
            dp[i] = (dp[i -1] + dp[i -2] + dp[i -3]) % 1_000_000_009;
        }
        while(t --> 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n] % 1_000_000_009);
        }
    }
}