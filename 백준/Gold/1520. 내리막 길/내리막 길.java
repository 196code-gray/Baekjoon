import java.io.*;
import java.util.*;

public class Main {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int[][] dp, map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); int n =Integer.parseInt(st.nextToken());
        dp = new int[m+2][n+2]; map = new int[m +2][n +2];
        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1;j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= m; i++){
            Arrays.fill(dp[i], -1); // 모두 -1로 초기화
        }
        dp[1][1] = 1; // 시작 지점 가능한 경우 1가지 (초기화)
        System.out.println(dfs(m, n));
    }
    static int dfs(int i, int j){
        if (dp[i][j] == -1){ // 아직 들리지 않은 경로
            dp[i][j] = 0; // 가능한 경우 0가지
            for (int now = 0; now < 4; now++){
                int ni = di[now] + i;
                int nj = dj[now] + j;
                if (map[ni][nj] > map[i][j]) { // 현재 값에서 가능한 상하좌우 중 더 큰 값이 있다면 그 경로로 따라감
                    dp[i][j] += dfs(ni, nj);
                }
            }
        }
        return dp[i][j];
    }
}