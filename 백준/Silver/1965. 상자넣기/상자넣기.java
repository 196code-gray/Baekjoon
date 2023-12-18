import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] box = new int[1001];
        int[] dp = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            box[i]=Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int max = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j < i; j++) {
                if (dp[i] < dp[j] + 1 && box[i] > box[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (int i : dp) {
            if (max < i) max = i;
        }
        System.out.println(max);
    }
}