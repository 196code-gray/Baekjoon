import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        int[] a = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++){
            dp[i] = 1;
            for (int j = 1; j <= i; j++){
                if (a[i] < a[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int min = 0;
        for (int i = 1; i <= n; i++){
            if (dp[i] > min) min = dp[i];
        }

        System.out.println(min);
    }
}
