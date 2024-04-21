import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][][] dp = new int[100_001][5][5];
        int[][] power = {
                {0, 2, 2, 2, 2}, // 0에서 0,1,2,3,4 로 가는 힘
                {2, 1, 3, 4, 3}, // 1에서 0,1,2,3,4
                {2, 3, 1, 3, 4}, // 2에서 0,1,2,3,4
                {2, 4, 3, 1, 3}, // 3에서 0,1,2,3,4
                {2, 3, 4, 3, 1}}; // 4에서 0,1,2,3,4

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                for (int k = 0; k < 100_001; k++){
                    dp[k][i][j] = 4 * 100_100; // 최대 10만 수열 + 최악의 경우 힘이 4로 가득 차있을 때
                }
            }
        }
        dp[0][0][0] = 0;
        int now = 1; // 시작점(1번째 수열)

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true){
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            // 오른발이 움직이는 경우
            for (int i = 0; i < 5; i++){ // 왼발 위치
                if (n == i) continue; // 같은 위치 발 안됨

                for (int j = 0; j < 5; j++){
                    dp[now][i][n] = Math.min(dp[now][i][n], dp[now -1][i][j] + power[j][n]);
                }
            }

            // 왼쪽발이 움직이는 경우
            for (int j = 0; j < 5; j++){ // 오른발 위치
                if (j == n) continue;

                for (int i = 0; i < 5; i++){  // 왼발 위치
                    dp[now][n][j] = Math.min(dp[now][n][j], dp[now -1][i][j] + power[i][n]);
                }
            }
            now++; // 수열 증가
        }
        now--; // 마지막 수열 위해 감소
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                ans = Math.min(ans, dp[now][i][j]);
            }
        }
        System.out.println(ans);
    }
}