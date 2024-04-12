import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[31][31];
        for (int i = 0; i <= 30; i++){
            for (int j = i; j <= 30; j++){
                if (i == 0) dp[j][0] = 1;
                else dp[j][i] = dp[j -1][i] + dp[j][i -1];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true){
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            sb.append(dp[num][num]).append("\n");
        }
        System.out.println(sb);
    }
}