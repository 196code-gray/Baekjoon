import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int[] tree = new int[t + 1];
        int[][] dp = new int[t + 1][w + 1];

        for (int i = 1; i <= t; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= t; i++) {
            if (tree[i] == 1) dp[i][0] = dp[i - 1][0] + 1;
            else dp[i][0] = dp[i - 1][0];

            for (int j = 1; j <= w; j++) {
                if ((tree[i] == 1 && j % 2 == 0) || (tree[i] == 2 && j % 2 != 0)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int max = dp[t][0];
        for (int i = 1; i <= w; i++) {
            max = Math.max(max, dp[t][i]);
        }
        System.out.println(max);
    }
}