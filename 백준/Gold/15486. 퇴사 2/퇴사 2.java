import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] day = new int[n + 1][2];    // 상담 진행 기간, 금액
        long[] dp = new long[1_500_002];    // 최댓값 150만 + 인덱스 1 + 퇴사일 + 1
        for (int i = 1; i <= n; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i][0] = Integer.parseInt(st.nextToken());
            day[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = n; i > 0; i--){
            // 퇴사일을 넘어가는 경우
            if (day[i][0] + i > n + 1) dp[i] = dp[i + 1];
            // 퇴사일을 넘어가지 않는 경우
            else dp[i] = Math.max(dp[i + 1], day[i][1] + dp[day[i][0] + i]);
        }
        System.out.println(dp[1]);
    }
}
