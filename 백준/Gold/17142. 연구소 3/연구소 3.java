import java.io.*;
import java.util.*;

public class Main {
    static int[][] map, time;
    static boolean[][] visited;
    static int n, m, ans = Integer.MAX_VALUE, empty, count;
    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Point[] virus;
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][n]; time = new int[n][n]; empty = 0;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) list.add(new Point(i, j));
                if (map[i][j] == 0) empty++;
            }
        }
        virus = new Point[m];
        dfs(0, 0);
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    private static void dfs(int depth, int idx) {
        if (depth == m){
            visited = new boolean[n][n];
            time = new int[n][n];
            for (int i = 0; i < m; i++){
                q.offer(new Point(virus[i].x, virus[i].y));
                visited[virus[i].x][virus[i].y] = true;
            }
            bfs();
            return;
        }

        for (int i = idx; i < list.size(); i++){
            virus[depth] = list.get(i);
            dfs(depth + 1, i + 1);
            visited[virus[depth].x][virus[depth].y] = false;
        }
    }

    private static void bfs() {
        count = 0; int result = 0;

        while (!q.isEmpty()){
                Point now = q.poll();
                int x = now.x;
                int y = now.y;
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + x;
                    int ny = dy[j] + y;

                if (isTure(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
                    time[nx][ny] = time[x][y] + 1;
                    if (map[nx][ny] == 0){
                        count++;
                        result = time[nx][ny];
                    }
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
                }
        }
        if (count == empty){
            ans = Math.min(ans, result);
        }
    }
    static boolean isTure (int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    static public class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}