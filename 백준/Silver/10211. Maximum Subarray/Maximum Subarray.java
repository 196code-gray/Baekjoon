import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] sum = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int now = Integer.parseInt(st.nextToken());
                sum[i] = now;
            }
            int ans = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++){
                if (sum[i] <= 0) { // 음수일 경우
                    ans = ans < sum[i] ? sum[i] : ans;
                    continue;
                }
                int now = sum[i];  // 현재 양수부터 제일 큰 합 구하기
                ans = ans < sum[i] ? sum[i] : ans;
                for (int j = i + 1; j <= N; j++){
                    now += sum[j];
                    if (now < 0) {
                        i = j; break; // 현재 값이 음수가 된 순간 i를 j까지 이동 이제 봐줄 필요 x
                    }
                    ans = now > ans ? now : ans;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}