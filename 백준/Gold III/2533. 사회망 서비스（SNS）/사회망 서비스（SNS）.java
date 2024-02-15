import java.util.*;
import java.io.*;

public class Main {
    static int n, parent;
    static ArrayList<Integer>[] e;
    static int[][] dp = new int[1_000_001][2]; // 0 어답터, 1 x
    static boolean[] visited=new boolean[1_000_001];

    public static void dfs(int x) {
        visited[x] = true;
        dp[x][0] = 1;
        for (int i = 0; i < e[x].size(); i++) {
            int child = e[x].get(i);
            if (visited[child]) continue;
            dfs(child);
            dp[x][1] += dp[child][0];
            dp[x][0] += Math.min(dp[child][1], dp[child][0]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        e = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            e[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            e[u].add(v);
            e[v].add(u);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}