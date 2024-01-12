import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i ++){
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = a[i];
        }
        int ans = 0;
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j < i; j++){
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
 }}
