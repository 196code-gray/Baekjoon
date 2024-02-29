import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테케
        int INF = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(); // 출력값 저장
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n][n];
            int[] file = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) file[i] = file[i-1] + Integer.parseInt(st.nextToken());
            
            for (int j = 1; j < n; j++) { // ~까지
                for (int i = j - 1; i >= 0; i--) { // i부터
                    int min = INF;
                    for (int k = 0; k < j - i; k++) { // 하나씩 i번째와 더해지는 file
                        min = Math.min(min, dp[i][i + k] + dp[i + k + 1][j]);
                        int sum = 0;
                        dp[i][j] = min + file[j+1]-file[i];
                    }
                }
            }
            System.out.println(dp[0][n - 1]);
        }
    }
}