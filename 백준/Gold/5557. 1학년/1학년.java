    import java.io.*;
    import java.util.*;
    
    public class Main {
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            long[][] dp = new long[n][21];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <=n; i++) arr[i] = Integer.parseInt(st.nextToken());
            dp[1][arr[1]] = 1;  // 맨 처음 값 경우의 수 체크
    
            for (int i = 2; i <= n -1; i++){    // 2번째 수부터 마지막 전 수까지
                for (int j = 0; j <= 20; j++) { // 0 ~ 20 사이라면 경우의 수 가능
                    if (dp[i -1][j] > 0){
                        if (j - arr[i] >= 0) dp[i][j - arr[i]] += dp[i -1][j];
                        if (j + arr[i] <= 20) dp[i][j + arr[i]] += dp[i -1][j];
                    }
                }
            }
            System.out.println(dp[n -1][arr[n]]);
        }
    }