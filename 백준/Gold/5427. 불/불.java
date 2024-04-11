import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int[][] copy;
    static Queue<int[]> q;
    static int h, w, ans;
    static boolean[][] visit;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());
            map = new char[h][w]; copy = new int[h][w];
            int x = 0; int y = 0; // 사람 위치
            for (int i = 0; i < h; i++){
                String s = br.readLine();
                for (int j = 0; j < w; j++){
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '@'){
                        x = i;
                        y = j;
                    }
                    if (map[i][j] == '.') copy[i][j] = Integer.MAX_VALUE;
                }
            }
            q = new LinkedList<>();
            // 불을 찾는다
            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (map[i][j] == '*') q.offer(new int[]{i, j, 0}); // 불 큐에 삽입
                }
            }
            fire();
            q.offer(new int[]{x, y, 0});
            ans = BFS();
            System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
        }
    }

    private static int BFS() {
        visit = new boolean[h][w];
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            visit[x][y]=true;

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                // 탈출
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    return cnt + 1;
                }
                if (copy[nx][ny] <= cnt + 1) continue;
                if (visit[nx][ny] || map[nx][ny] != '.') continue;
                q.offer(new int[]{nx, ny, cnt + 1});
                visit[nx][ny] = true;
            }
        }
        return -1;
    }

    private static void fire() {
        visit = new boolean[h][w];
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            visit[x][y] = true;

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (visit[nx][ny] || map[nx][ny] == '#') continue;

                q.offer(new int[]{nx, ny, cnt + 1});
                visit[nx][ny] = true;
                copy[nx][ny] = cnt + 1;
            }
        }
    }
}