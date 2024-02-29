import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s  = " " + br.readLine();
        long[] dp = new long[s.length()];

        if (s.charAt(1) == '0') {
            System.out.println(0);
            return;
        }

        dp[0] = dp[1] = 1;
        for (int i = 2; i < s.length(); i++){
            if ((s.charAt(i) -'0') > 0 && (s.charAt(i) -'0') < 10) dp[i] += (dp[i - 1]) % 1000000;
            String c = String.valueOf(s.charAt(i -1)) + (s.charAt(i));
            if ((Integer.parseInt(c)) > 9 && Integer.parseInt(c) < 27){
                dp[i] += (dp[i -2]) % 1000000;
            }
        }
        System.out.println(dp[s.length() -1] % 1000000);
    }
}