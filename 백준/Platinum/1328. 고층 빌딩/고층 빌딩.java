import java.util.*;
import java.io.*;

public class Main {
    // 나누기 수
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long[][][] s = new long[102][102][102];

        s[1][1][1] = 1; // 초기값 세팅

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    s[i][j][k] = (s[i-1][j][k] * (i-2) + s[i-1][j][k-1] + s[i-1][j-1][k]) % MOD;
                }
            }
        }

        System.out.println(s[n][l][r] % MOD);
    }
}