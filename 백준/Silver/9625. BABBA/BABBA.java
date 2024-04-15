import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[46][2];
        dp[1][0] = 0; dp[1][1] = 1;
        dp[2][0] = 1; dp[2][1] = 1;

        for (int i = 3; i <= 45; i++){
                dp[i][0] = dp[i -1][0] + dp[i -2][0];
                dp[i][1] = dp[i -1][1] + dp[i -2][1];
        }
        System.out.println(dp[k][0] + " " + dp[k][1]);
    }
}