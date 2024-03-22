import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] num = new int[n + 1], lion = new int[n + 1];
        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if (num[i] == 1) {
                lion[(int) ans++] = i;  // 라이언 위치 저장
            }
        }

        ans = Long.MAX_VALUE;
        int s = 1, e = k;

        while (s < e) {
            if (lion[e] == 0 || lion[s] == 0) break;
            if (e == n + 1) {
                if (e - s < k) break;
                ans = Math.min(ans, e - s);
                s++;
            }
            ans = Math.min(lion[e++] - lion[s++] + 1, ans);
        }
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}