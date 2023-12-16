import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'L') arr[i][j] = 1;
                else arr[i][j] = 0;
            }
        }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        visited = new boolean[n][m];
                        bfs(i, j);
                    }
                }
            }
        System.out.println(max);
    }
    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y, x, 0});
        int count = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int len = now[2];
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[0];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx] && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, len + 1});
                }
            }
            if (count < len) count = len;
        }
        max = Math.max(count, max);
    }
}