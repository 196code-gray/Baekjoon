import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] T,P; T = new int[n + 1]; P = new int[n + 1]; // 시간, 금액
        long[] dp = new long[n + 2];
        for (int i = 1; i<= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i]  =Integer.parseInt(st.nextToken());
        }

        for (int i = n; i > 0; i--){
            if (T[i] + i <= n + 1){ // 기간 안에 가능
                dp[i] = Math.max(dp[i + 1], dp[T[i] + i] + P[i]);
            }
            else dp[i] = dp[i + 1]; //기간 안에 불가능
        }
        System.out.println(dp[1]);
    }
}