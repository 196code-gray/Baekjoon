import java.util.*;
import java.io.*;

class Main{
    static long[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          dp = new long[21][21][21];
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;
            //w(1, 1, 1) = 2
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
        }
        System.out.println(sb);
    }
    public static long w(int a, int b, int c) {
        if (isBoundary(a,b,c) && dp[a][b][c] != 0) return dp[a][b][c];
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
            return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
    static boolean isBoundary(int a, int b, int c){
        return a >= 0 && b >= 0 && c >= 0 && a < 21 && b < 21 && c < 21;
    }
}
