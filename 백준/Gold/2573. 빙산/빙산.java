import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int n, m, time;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        time = 0;
        while (true) {
            int p = piece();
            if (p > 1) break; // 덩어리가 2개 이상일 경우 종료
            if (p == 0) { // 얼음이 전부 녹았을 경우 종료
                time = 0;
                break;
            }
            visit = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && map[i][j] == 0) {
                        bfs(i, j);
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }

    static int piece() {
        int p = 0;
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j] != 0) {
                    p++;
                    check(i, j);
                }
            }
        }
        return p;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx >= n || ny >= m || nx < 0 || ny < 0 ) continue;
                if (visit[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                } else if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    visit[nx][ny] = true;
                } else map[nx][ny]--;
            }
        }
    }

    static void check(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                if (visit[nx][ny]) continue;

                if (map[nx][ny] != 0){
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }
}