import java.io.*;
import java.util.*;

public class Main {
    static boolean[][][] visit;
    static String[][][] building;
    static Queue<int[]> q;
    static int L, R, C;
    static StringBuilder sb;
    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new LinkedList<>();
        sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0) break;

            building = new String[L][R][C];
            visit = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                if (i > 0) br.readLine();
                for (int j = 0; j < R; j++) {
                    String[] s = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = s[k];
                        if (s[k].equals("S")) q.offer(new int[]{i, j, k, 0});
                    }
                }
            }

            BFS();
            q.clear();
            br.readLine();
        }
        System.out.println(sb);
    }

    static void BFS() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int h = now[0];
            int x = now[1];
            int y = now[2];
            visit[h][x][y] = true;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nh = h + dh[i];

                if (nh < 0 || nh >= L || nx < 0 || nx >= R || ny >= C || ny < 0) continue;

                if (building[nh][nx][ny].equals("E")) {
                    sb.append("Escaped in ").append(now[3] + 1).append(" minute(s).").append("\n");
                    return;
                }

                if (visit[nh][nx][ny] || building[nh][nx][ny].equals("#")) continue;

                q.offer(new int[]{nh, nx, ny, now[3] + 1});
                visit[nh][nx][ny] = true;

            }
        }
        sb.append("Trapped!").append("\n");
    }
}