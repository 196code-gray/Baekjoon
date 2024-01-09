    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0){
                System.out.println(1);
                return;
            }
            long[][] dp = new long[1001][1001];
            dp[0][0] = dp[1][0] = 1;
            for (int i = 1; i <= n; i ++){
                for (int j = 0; j <= i; j++){
                    if (j == 0) dp[i][j] = 1;
                    else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
                }
            }
            System.out.println(dp[n][k] % 10007);
        }
    }