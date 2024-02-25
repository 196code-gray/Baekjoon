import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Pair[] items = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            items[i] = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        long s_max = 1 + Arrays.stream(items).mapToLong(x -> x.second).max().getAsLong() * k;
        long[][] dp = new long[k + 1][(int) s_max + 1];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MIN_VALUE);
        }

        dp[0][1] = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= s_max; j++) {
                if (dp[i][j] < 0) {
                    continue;
                }

                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + j);

                for (int l = 0; l < n; l++) {
                    if (j + items[l].second < dp[i + 1].length) {
                        dp[i + 1][j + (int) items[l].second] =
                                Math.max(dp[i + 1][j + (int) items[l].second], dp[i][j] - items[l].first);
                    }
                }
            }
        }

        writer.println(Arrays.stream(dp[k]).max().getAsLong());
        writer.flush();
        writer.close();
        reader.close();
    }

    static class Pair {
        long first;
        long second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}