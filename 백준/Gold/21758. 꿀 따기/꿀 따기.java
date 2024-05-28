import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, ans;
    static int[] honey, sum;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        honey = new int[n+1]; sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            honey[i] = Integer.parseInt(st.nextToken());
            sum[i] = honey[i] + sum[i -1];
        }

        // 벌 - 꿀 - 벌
        for (int i = 2; i < n; i++){
            int now = (sum[i] - sum[1]) + (sum[n -1] - sum[i -1]);
            ans = Math.max(ans , now);
        }
        // 벌 - 벌 - 꿀
        for (int i = 2; i < n; i++){
            int now = (sum[n] - sum[1] - honey[i]) + (sum[n] - sum[i]);
            ans = Math.max(ans, now);
        }

        // 굴 - 벌 - 벌
        for (int i = 2; i < n; i++){
            int now = (sum[n -1] - honey[i]) + sum[i -1];
            ans = Math.max(ans, now);
        }

        System.out.println(ans);
    }
}