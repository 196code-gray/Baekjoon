import java.io.*;
import java.util.*;

public class Main {
    static class UnsafeScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public UnsafeScanner(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        public String next() {
            while (!tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        UnsafeScanner scan = new UnsafeScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = scan.nextInt();
        long x = scan.nextLong();
        long[] heights = new long[n + 2];

        for (int i = 1; i <= n; i++) {
            heights[i] = scan.nextLong();
        }

        heights[0] = heights[1] - x;
        heights[n + 1] = heights[n] - x;

        long ret = Long.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            long ret1 = Math.max(0, x - (heights[i] - heights[i - 1]))
                    + Math.max(0, x - (heights[i + 1] - Math.max(heights[i], heights[i - 1] + x)));
            long ret2 = Math.max(0, x - (heights[i] - heights[i - 1]))
                    + Math.max(0, x - (Math.max(heights[i], heights[i - 1] + x) - heights[i + 1]));
            long ret3 = Math.max(0, x - (heights[i - 1] - heights[i]))
                    + Math.max(0, x - (heights[i + 1] - heights[i]));
            long ret4 = Math.max(0, x - (heights[i] - heights[i + 1]))
                    + Math.max(0, x - (heights[i - 1] - Math.max(heights[i], heights[i + 1] + x)));

            ret = Math.min(ret, Math.min(ret1, Math.min(ret2, Math.min(ret3, ret4))));
        }

        out.println(ret);
        out.flush();
    }
}
