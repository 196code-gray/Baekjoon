import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[100 + c];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j = customer; j < c + 100; j++) {
                if (dp[j - customer] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], money + dp[j - customer]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = c; i < c + 100; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}