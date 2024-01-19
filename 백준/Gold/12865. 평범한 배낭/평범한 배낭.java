import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n +1][k + 1];
        int[][] a = new int[n +1][2];

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++){
            for (int j= 1; j <= k; j++){
                if (j - a[i][0] >= 0){  // 현재 담을 수 있는 가방의 무게가 현재 물건을 넣고 다른 물건도 넣을 수 있는지
                    dp[i][j] = Math.max(dp[i-1][j], dp[i -1][j - a[i][0]] + a[i][1]);
                } else {
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}