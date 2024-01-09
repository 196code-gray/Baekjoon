    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String args[]) throws IOException {
            long[][] dp = new long[31][31];
            for (int h = 0; h <= 30; h++){
                for (int w = h; w <= 30; w++){
                    if (h == 0) dp[w][0] = 1;   // n개의 w개수는 항상 1개의 경우의 수가 존재
                    else dp[w][h] = dp[w][h -1] + dp[w -1][h];
                }
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                int n = Integer.parseInt(br.readLine());
                if (n == 0) break;
                System.out.println(dp[n][n]);
            }
        }
    }