import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        long[] sum = new long[n + 1]; // 누적합
        st = new StringTokenizer(br.readLine()); long ans = Integer.MIN_VALUE;
        for (int i = 1; i<= n; i++){
            sum[i] = sum[i -1] + Integer.parseInt(st.nextToken());
        }
        for (int i = k; i <= n; i++){
            ans = Math.max(sum[i] - sum[i - k], ans);
        }
        System.out.println(ans);
    }
}