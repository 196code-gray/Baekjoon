import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dessert, cache;

    static int stoi(String s) { return Integer.parseInt(s); }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        dessert = new int[M][N];
        cache = new int[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(cache[i], -1);
            for (int j = 0; j < N; j++)
                dessert[i][j] = stoi(st.nextToken());
        }

        System.out.println(dp(0, 0));
    }

    static int dp(int day, int prev) {
        if(day == N) return 0;

        int ret = cache[prev][day];
        if(ret != -1) return ret;

        ret = 0;
        for(int i = 0; i < M; i++) {
            if(day != 0 && i == prev)
                ret = Math.max(ret ,dp(day + 1, i) + dessert[i][day] / 2);
            else
                ret = Math.max(ret ,dp(day + 1, i) + dessert[i][day]);
        }
        return cache[prev][day] = ret;
    }
}