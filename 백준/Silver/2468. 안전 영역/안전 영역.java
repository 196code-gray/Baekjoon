import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, ans;
    static int[][] rainMap;
    static List<int[]> list;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = 0;
        rainMap = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            list = new ArrayList<>();
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                rainMap[i][j] = Integer.parseInt(st.nextToken());
                if (max < rainMap[i][j]) max = rainMap[i][j];
            }
        }
        // 비가 내리는 깊이를 증가
        for (int rain = 0; rain < max; rain++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (rainMap[i][j] <= rain) {
                        rainMap[i][j] = -1;     // 잠긴 도시
                    } else {
                        list.add(new int[]{i, j});  // 잠기지 않은 도시 저장
                    }
                }
            }
            bfs();
        }
        System.out.println(ans);
    }

    static void bfs() {
        int max = 0;
        visited = new boolean[n + 1][n + 1];
        for (int[] down : list) {
            if (visited[down[0]][down[1]]) continue;
            q.offer(new int[]{down[0], down[1]});
            max++;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                visited[x][y] = true;

                for (int i = 0; i < 4; i++){
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;

                    if(nx > 0 && ny > 0 && nx <= n && ny <= n && !visited[nx][ny] && rainMap[nx][ny] != -1){
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if (max > ans) ans = max;
        list.clear();
    }
}