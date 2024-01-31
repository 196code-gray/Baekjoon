import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] dp = new int[n+1]; int[] a = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 1;  i < n; i++){
            for (int j = 1; j <= a[i]; j++){
                if (i + j <= n) dp[j+i] = Math.min(dp[j+i], dp[i] + 1);
            }
        }
        System.out.println(dp[n] < 0 || dp[n] == Integer.MAX_VALUE ? -1 :  dp[n]);
    }
}