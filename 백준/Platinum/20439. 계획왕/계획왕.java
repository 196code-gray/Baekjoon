import java.util.*;

public class Main {

    static int N, K;
    static int[] rest = new int[12];   
    static int[] plan = new int[12];  
    static int[][][] dp = new int[12][4096][1441];  

    static int solve(int ind, int res, int rem) {
        if (res == (1 << K) - 1) return 1;  
        if (dp[ind][res][rem] != -1) return dp[ind][res][rem];
        else dp[ind][res][rem] = 0;

        for (int i = 0; i < K; i++) {
            int idx = ind;

            if ((res & (1 << i)) != 0) continue;  

            if (rem >= plan[i]) {
                dp[ind][res][rem] |= solve(idx, res | (1 << i), rem - plan[i]);
            } else {
                while (++idx <= N && rest[idx] < plan[i]) {
                }
             
                if (idx > N) return 0; 

                dp[ind][res][rem] |= solve(idx, res | (1 << i), rest[idx] - plan[i]);
            }
        }
        return dp[ind][res][rem];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        int k = 0;
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            rest[i] = s - k;
            k = e;
        }
        rest[N] = 1440 - k;

        for (int i = 0; i < K; i++) plan[i] = sc.nextInt();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4096; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = solve(0, 0, rest[0]);
        if (ans == 1) System.out.println("GOOD");
        else System.out.println("BAD");

        sc.close();
    }
}