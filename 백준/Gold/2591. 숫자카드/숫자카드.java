import java.io.*;

public class Main {
    static BufferedReader br;
    static String s;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 1; i < s.length(); i++){
            dp[i + 1] += dp[i];
            if (isPossible(s.charAt(i -1), s.charAt(i)))
                dp[i + 1] += dp[i -1];
            if (s.charAt(i) == '0')
                dp[i + 1] -= dp[i];
        }

        System.out.println(dp[s.length()]);
    }

    private static boolean isPossible(char c1, char c2) {
        if (c1 == '0') return false;
        int num = (c1 - '0') * 10 + (c2 - '0');
        return 1 <= num && num <= 34;
    }

}