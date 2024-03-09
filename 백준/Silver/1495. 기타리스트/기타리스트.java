import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int start = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][]dp = new int[n + 1][m + 1]; int[] volume = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= n; i++) volume[i] = Integer.parseInt(st.nextToken()); // 볼륨 입력받기

        if (start - volume[1] >= 0) dp[1][start - volume[1]] = 1;
        if (start + volume[1] <= m) dp[1][start + volume[1]] = 1;

        for (int i = 2; i <= n; i++){
            boolean updown = false;
            for (int j = 0; j <= m; j++){
                if (dp[i -1][j] != 0){ // 전에 볼륨이 가능햇을 경우
                    if (j - volume[i] >= 0) {
                        dp[i][j - volume[i]] += 1;
                        updown = true;
                    }
                    if (j + volume[i] <= m) {
                        dp[i][j + volume[i]] += 1;
                        updown = true;
                    }
                }
            }
            if (!updown) {
                System.out.println(-1);
                return;
            }
        }
        int ans = 0;
        boolean isTrue = false;
        for (int i = m; i >= 0; i--){
            if (dp[n][i] != 0) {
                ans = i;
                isTrue = true;
                break;
            }
        }
        System.out.println(isTrue ? ans : -1);
    }
}