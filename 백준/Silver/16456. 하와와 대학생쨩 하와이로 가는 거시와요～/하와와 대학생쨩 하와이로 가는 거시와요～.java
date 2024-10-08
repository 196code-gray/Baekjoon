import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long dp[] = new long[50001];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        if(n>3){
            for(int i = 4;i<=n;i++){
                dp[i] = (dp[i-1] + dp[i - 3]) % 1000000009;
            }
        }
        System.out.println(dp[n]);
    }
}