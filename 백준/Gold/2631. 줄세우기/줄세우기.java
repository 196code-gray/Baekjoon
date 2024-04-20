import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] child = new int[n]; int[] dp = new int[n];

        for (int i = 0; i < n; i++) child[i] = Integer.parseInt(br.readLine());
        dp[0] = 1;
        int max = 0;

        for (int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j= 0; j < i; j++){
                if (child[i] > child[j]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(n -  max);
    }
}