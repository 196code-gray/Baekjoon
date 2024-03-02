import java.io.*;
import java.util.*;

public class Main {
    static int[][] map, dp;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n + 2][n+2]; dp = new int[n+2][n+2];

        for (int i = 1;i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j= 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i= 1;i <= n;i++){
            for (int j = 1; j<= n; j++){
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }
    static int dfs(int i, int j){
        if (dp[i][j] == 0){ // 처음 방문
            dp[i][j] = 1;
            for (int cost = 0; cost < 4; cost++){
                int ni = di[cost] + i;
                int nj = dj[cost] + j;

                if (map[ni][nj] > map[i][j]){
                    dp[i][j] = Math.max(dfs(ni, nj) + 1, dp[i][j]);
                }
            }
        }
        return dp[i][j];
    }
}