import java.util.*;
import java.io.*;

    class Tree {
        int n;
        int[] t;
        final int inf = 1000000009;

        Tree(int n) {
            this.n = n;
            t = new int[n * 2];
            Arrays.fill(t, inf); 
        }

        void update(int x, int v) {
            x += n;
            while (x > 0) {
                t[x] = Math.min(t[x], v);
                x >>= 1;
            }
        }

        int query(int l, int r) {
            int res = inf;
            for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
                if ((l & 1) != 0) res = Math.min(res, t[l++]);
                if ((r & 1) != 0) res = Math.min(res, t[--r]);
            }
            return res;
        }
    }

    class Cookie {
        int x, r, c;

        Cookie(int x, int r, int c) {
            this.x = x;
            this.r = r;
            this.c = c;
        }
    }

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Cookie[] v = new Cookie[k];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                v[i] = new Cookie(x, r, c);
            }

            Arrays.sort(v, Comparator.comparingInt(a -> a.x));

            Tree dp = new Tree(n + 1);
            dp.update(0, 0);

            int idx = 0;
            for (Cookie e : v) {
                while (idx + 1 < e.x) {
                    dp.update(idx + 1, dp.query(idx, idx + 1));
                    idx++;
                }

                int mn = dp.query(Math.max(0, e.x - e.r - 1), Math.min(n, e.x + e.r) + 1);

                dp.update(Math.min(n, e.x + e.r), mn + e.c);
                idx = e.x;

                dp.update(e.x, dp.query(e.x - 1, e.x) + e.c);
            }

            while (idx < n) {
                dp.update(idx + 1, dp.query(idx, idx + 1));
                idx++;
            }

            System.out.println(dp.query(n, n + 1));
        }
    }