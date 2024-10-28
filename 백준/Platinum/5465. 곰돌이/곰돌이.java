import java.io.*;
import java.util.*;

public class Main {
    static int n, m, sx, sy, ex, ey;
    static int[][] dist = new int[800][800];
    static int[][] dist2 = new int[800][800];
    static String[] board = new String[800];
    static Queue<int[]> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for (int[] row : dist) Arrays.fill(row, -1);

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
            for (int j = 0; j < n; j++) {
                char cell = board[i].charAt(j);
                if (cell == 'M') {
                    sx = i;
                    sy = j;
                } else if (cell == 'D') {
                    ex = i;
                    ey = j;
                } else if (cell == 'H') {
                    dist[i][j] = 0;
                    Q.add(new int[]{i, j});
                }
            }
        }

        bfs();

        int lo = -1, hi = (int) 1e6;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) lo = mid;
            else hi = mid;
        }
        out.println(lo);
        out.flush();
    }

    static void bfs() {
        while (!Q.isEmpty()) {
            int[] cell = Q.poll();
            int x = cell[0], y = cell[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + "1012".charAt(k) - '1';
                int ny = y + "2101".charAt(k) - '1';
                if (OOB(nx, ny) || (board[nx].charAt(ny) != 'G' && board[nx].charAt(ny) != 'M')) continue;
                if (dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[x][y] + 1;
                Q.add(new int[]{nx, ny});
            }
        }
    }

    static boolean check(int mid) {
        if (dist[sx][sy] <= mid) return false;
        for (int[] row : dist2) Arrays.fill(row, -1);

        dist2[sx][sy] = mid;
        Q.add(new int[]{sx, sy});

        for (int cnt = 1; !Q.isEmpty(); cnt++) {
            for (int _ = 0; _ < m; _++) {
                int qSize = Q.size();
                for (int i = 0; i < qSize; i++) {
                    int[] cell = Q.poll();
                    int x = cell[0], y = cell[1];
                    for (int k = 0; k < 4; k++) {
                        int nx = x + "1012".charAt(k) - '1';
                        int ny = y + "2101".charAt(k) - '1';
                        if (OOB(nx, ny) || dist2[nx][ny] != -1) continue;
                        if (board[nx].charAt(ny) == 'T') continue;
                        if (dist[nx][ny] != -1 && dist[nx][ny] < mid + cnt) continue;
                        dist2[nx][ny] = mid + cnt;
                        Q.add(new int[]{nx, ny});
                    }
                }
            }
            int qSize = Q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cell = Q.poll();
                int x = cell[0], y = cell[1];
                if (dist[x][y] <= dist2[x][y]) continue;
                Q.add(new int[]{x, y});
            }
        }
        return dist2[ex][ey] != -1;
    }

    static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}