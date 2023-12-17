import java.io.*;
import java.util.*;

public class Main {
    static int Max (int a, int b) {
        return a > b ? a : b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][100_001];
            int[][] arr = new int[2][100_001];

            for (int i = 0; i <= 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = dp[1][0] = 0;
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }
            System.out.println(Max(dp[0][n], dp[1][n]));
        }
        }
    }