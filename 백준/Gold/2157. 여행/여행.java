import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[n + 1];
        int[][] dp = new int[n + 1][m + 1];  // i번째 섬을 j번째 이동하여 갈 수 있는 최댓값.

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1); // 방문 확인 위한 -1 처리
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if (s > e) continue;  // 무조건 더 크게 가야하기 때문에
            list[s].add(new Node(e, p));
        }

        for (int i = 0; i < list[1].size(); i++) {
            int to = list[1].get(i).to;
            int score = list[1].get(i).score;

            dp[to][2] = Math.max(dp[to][2], score);
        }

        for (int M = 2; M < m; M++) {
            for (int city = 1; city <= n; city++) {
                for (Node now : list[city]) {
                    if (dp[city][M] == -1) continue;

                    int next = now.to;
                    int p = now.score;

                    // 다음 이동이기때문에 M+1
                    dp[next][M + 1] = Math.max(dp[next][M + 1], dp[city][M] + p);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i<= m; i++){
            ans = Math.max(dp[n][i], ans);
        }
        System.out.println(ans);
    }

    static class Node {
        int to;
        int score;

        public Node(int to, int score) {
            this.to = to;
            this.score = score;
        }
    }
}