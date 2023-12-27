import java.io.*;
import java.util.*;

public class Main {
    static Integer[][] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new Integer[n][n]; dp = new Integer[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 0; i < n; i++){
            dfs(n -1, i);
        }
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, dp[n -1][i]);
        }
        System.out.println(max);

      }
      static int dfs(int row, int col){
        if (dp[row][col] == null){
            if (col == 0){
                dp[row][col] = dfs(row -1, col) + arr[row][col];
            } else if (col == row){
                dp[row][col] = dfs(row -1, col -1) + arr[row][col];
            } else {
                dp[row][col] = Math.max(dfs(row -1, col), dfs(row -1, col-1)) + arr[row][col];
            }
        }
        return dp[row][col];
      }
}