import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1], dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++){
            dp[i] = Math.max(arr[i], dp[i -1] + arr[i]);
            if (max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}