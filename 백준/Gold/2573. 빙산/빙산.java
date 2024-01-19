import java.io.*;
import java.util.*;

class Main{
    static int[] dx = {0, -1, 0 , 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int n,m,time,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        time = count = 0;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int now = 0;
        while (true){
            visited = new boolean[n][m];
            if (iceberg() > 1) break;
            if (count == 0) {
                System.out.println(0);
                return;
            }
            time = now;
            visited = new boolean[n][m];

            for (int i = 0; i< n; i++){
                for (int j = 0; j < m; j++){
                    if (map[i][j] == 0 && !visited[i][j]){
                        bfs(i, j);
                    }
                }
            }
            now ++;
        }
        System.out.println(now);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (isBoundary(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
                else if (isBoundary(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    map[nx][ny] -= 1;
                    visited[nx][ny] = true;
                } else if (isBoundary(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0){
                    map[nx][ny] -= 1;
                }
            }
        }
    }
    static void findIceberg(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (isBoundary(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static boolean isBoundary(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    private static int iceberg() {
        count = 0;
        for (int i = 0; i< n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] != 0 && !visited[i][j]){
                    count++;
                    findIceberg(i, j);
                }
            }
        }
        return count;
    }
}
