import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            if (n==1) {
                System.out.println(1);
                continue;
            }
            if (n==2) {
                System.out.println(2);
                continue;
            }
            if (n==3) {
                System.out.println(4);
                continue;
            }
            int dp[] = new int[n];
            dp[0] = 1; dp[1] = 2; dp[2] = 4;
            for (int i = 3;i<n;i++){
                dp[i] = dp[i -1] + dp[i -2] + dp[i - 3];
            }
            System.out.println(dp[n -1]);
        }
    }
}