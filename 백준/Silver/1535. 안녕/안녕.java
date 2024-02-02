import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] happy = new int[n]; int[] sjH = new int[n]; int[][] dp = new int[n +1][101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sjH[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) happy[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n;i++){
            for (int j = 1; j <= 100; j++){
                if (sjH[i] <= j) { // 현재 체력이 작거나 같을 때 = 인사를 할 수 있는 체력일 때
                    dp[i +1][j] = Math.max(dp[i][j], dp[i][j - sjH[i]] + happy[i]);
                }
                else dp[i +1][j] = dp[i][j];    // 체력이 없을 때 = 인사를 못 할 때
            }
        }

        System.out.println(dp[n][99]);
    }
}