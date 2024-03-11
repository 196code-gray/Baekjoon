import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[] sum = new int[n + 1];
        st =new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i -1];
        }
        int ans = 0;
        for (int i = n; i >= 0; i--){
            for (int j = i -1; j >= 0; j--){
                if (sum[i] - sum[j] == m) ans++;
            }
        }
        System.out.println(ans);
    }
}