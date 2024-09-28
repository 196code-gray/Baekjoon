import java.io.*;
import java.util.*;

public class Main {
    static final int n_ = 300100;   // 최대 배열 크기
    static final long inf = (long) 1e18; 
    static final long mod = (long) 1e9 + 7;
    static final int sqrtN = 333;
    static final int p = 27;
    static final int m_ = 55;

    // 방향 배열 (dy, dx)
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    static int n, m, k, tc = 1, a, b, c, d, sum, x, y, z, w, base;
    static long ans;
    static int[] A = new int[n_];
    static int[] dp = new int[n_];
    static int[] G = new int[n_];
    static int[] Par = new int[n_];
    static ArrayList<Integer>[] v = new ArrayList[n_];

    static long gcd(long x, long y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    static long f(int x, int par) {
        if (dp[x] != -1) return dp[x];
        long ret = 0;
        for (int nxt : v[x]) {
            if (nxt == par) continue;
            Par[nxt] = x;
            if (f(nxt, x) == 0) ret++;
        }
        return dp[x] = (int)ret;
    }

    static long g(int x) {
        if (G[x] != -1) return G[x];
        long ret = 0;
        int par = Par[x];
        if (x != 1 && g(par) != 0) return G[x] = 0;
        ret += f(par, x);
        if (f(x, 0) == 0) ret--;
        return G[x] = (ret == 0) ? 1 : 0;
    }

    static void solve() throws IOException {
        Arrays.fill(dp, -1);
        Arrays.fill(G, -1);
        G[1] = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n_; i++) v[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            v[a].add(b);
            v[b].add(a);
        }

        f(1, 0);

        for (int i = 1; i <= n; i++) {
            boolean ok = false;
            if (f(i, 0) != 0 || g(i) != 0) System.out.println("Zeze");
            else System.out.println("Portuga");
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}