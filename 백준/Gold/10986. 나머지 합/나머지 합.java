import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        long[] sum = new long[n + 1]; long[] combination = new long[m]; // 누적합
        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            sum[i] = (sum[i -1] + Integer.parseInt(st.nextToken())) % m;
            combination[(int) sum[i]]++;
            if (sum[i] == 0) ans++;
        }
        for (long i : combination){
            ans += i * (i -1)/2;
        }
        System.out.println(ans);
    }
}