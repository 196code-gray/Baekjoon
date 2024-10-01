import java.util.Scanner;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static boolean compare(int n, int prev, int cur) {
        for (int i = 0; i < n; i++) {
            int a = prev & 1, b = cur & 1;
            if ((a ^ b) != 0) return a < b;
            prev >>= 1;
            cur >>= 1;
        }
        return true;
    }

    static void toggle(int m, int n, boolean[][] v, int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
            v[ny][nx] = !v[ny][nx];
        }
        v[y][x] = !v[y][x];
    }

    static boolean check(int m, int n, boolean[][] v) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j]) return false;
            }
        }
        return true;
    }

    static void solve() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[][] a = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                a[i][j] = (x == 1);
            }
        }

        int mn = Integer.MAX_VALUE;
        int idx = (1 << (n + 1)) - 1;

        for (int mask = 0; mask < (1 << n); mask++) {
            boolean[][] b = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                System.arraycopy(a[i], 0, b[i], 0, n);
            }
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) toggle(m, n, b, 0, i);
            }

            int cnt = Integer.bitCount(mask);
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!b[i - 1][j]) continue;
                    toggle(m, n, b, i, j);
                    cnt++;
                }
            }
            if (!check(m, n, b) || cnt > mn) continue;
            if (cnt == mn && compare(n, idx, mask)) continue;
            mn = cnt;
            idx = mask;
        }

        if (mn == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        boolean[][] ans = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if ((idx & (1 << i)) != 0) {
                toggle(m, n, a, 0, i);
                ans[0][i] = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!a[i - 1][j]) continue;
                toggle(m, n, a, i, j);
                ans[i][j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((ans[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}