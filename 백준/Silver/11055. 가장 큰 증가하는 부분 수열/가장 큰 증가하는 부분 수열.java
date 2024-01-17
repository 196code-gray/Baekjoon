import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = a[1];
        int ans = a[1];
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                if (a[i] > a[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += a[i];
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}