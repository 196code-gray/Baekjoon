import java.io.*;
import java.util.*;

public class Main {
    static public class Location{
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] map;
    static Queue<int[]> q;
    static int[][] virus;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static ArrayList<Location> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        map = new int[n][n]; list = new ArrayList<>();
        virus = new int[m+1][2];

        for (int i = 0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2){
                    list.add(new Location(i, j));
                }
            }
        }

        DFS(0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    static void DFS(int depth, int start){
        if (depth == m) {
            BFS();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            virus[depth][0] = list.get(i).x;
            virus[depth][1] = list.get(i).y;
            DFS(depth + 1, i +1);
        }
    }

    private static void BFS() {
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < m; i++){
            q.offer(new int[]{virus[i][0], virus[i][1], 0});
                        visit[virus[i][0]][virus[i][1]] = true;
        }
        int max = 0;
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1];
            visit[x][y] = true;

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx <0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visit[nx][ny] || map[nx][ny] == 1) continue;

                q.offer(new int[]{nx, ny, now[2] + 1});
                visit[nx][ny] = true;
                max = Math.max(max, now[2] + 1);
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n;j++){
                if (!visit[i][j] && map[i][j] != 1) return;
            }
        }
        ans = Math.min(ans , max);
    }
}