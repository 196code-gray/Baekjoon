import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] s = new int[n][t + 1];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= t; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][t + 1];
        int[][] tr = new int[n + 1][t + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= t; j++) {
                for (int k = 0; k <= t; k++) {
                    if (t < j + k) break;
                    if (dp[i + 1][j + k] < dp[i][j] + s[i][k]) {
                        dp[i + 1][j + k] = dp[i][j] + s[i][k];
                        tr[i + 1][j + k] = k;
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        int at = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= t; i++) {
            int d = Integer.parseInt(st.nextToken());
            if (ans < dp[n][i] - d) {
                ans = dp[n][i] - d;
                at = i;
            }
        }

        ArrayList<Integer> v = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            v.add(tr[i + 1][at]);
            at -= tr[i + 1][at];
        }

        bw.write(ans + "\n");
        Collections.reverse(v);
        for (int x : v) {
            bw.write(x + " ");
        }
        bw.write("\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}