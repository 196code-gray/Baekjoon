import java.io.*;
import java.util.*;

public class Main {

    static int n, open1, open2, m;
    static int[] use;
    // i번 이동했고, open1의 열린위치는 first, open2의 열린위치는 second 일때의 최소 이동횟수
    static int[][][] dp;
    static final int INF = Integer.MAX_VALUE;
    static int ans;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

         br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        open1 = Integer.parseInt(st.nextToken()); open2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        use = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            use[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[21][21][21]; // 현재 열어야하는 벽장, 모든 벽장, 모든 벽장

        // dp배열 초기화
        for (int i = 0; i <= m; i++) {
            for (int first = 1; first <= n; first++) {
                for (int second = 1; second <= n; second++) {
                    dp[i][first][second] = INF;
                }
            }
        }

        dp[0][open1][open2] = 0; // 이동이 없는 경우(맨 처음)

        ans = INF;
        for (int i = 0; i < m; i++) {
            for (int first = 1; first <= n; first++) {
                for (int second = 1; second <= n; second++) {

                    if (dp[i][first][second] == INF) continue; // 벽장문을 못 여는 경우

                    // 첫번째 벽장을 옮기는 경우
                    dp[i + 1][use[i + 1]][second] = 
                            Math.min(dp[i + 1][use[i + 1]][second], dp[i][first][second] + Math.abs(first - use[i + 1]));
                    
                    // 두번째 벽장을 옮기는 경우
                    dp[i + 1][first][use[i + 1]] = 
                            Math.min(dp[i + 1][first][use[i + 1]], dp[i][first][second] + Math.abs(second - use[i + 1]));

                    if (i == m - 1) {
                        if (ans > dp[i + 1][use[i + 1]][second])
                            ans = dp[i + 1][use[i + 1]][second];
                        if (ans > dp[i + 1][first][use[i + 1]])
                            ans = dp[i + 1][first][use[i + 1]];
                    }
                }
            }
        }
        System.out.println(ans);
    }
}