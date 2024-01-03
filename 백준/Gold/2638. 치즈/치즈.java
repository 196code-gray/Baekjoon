import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int n, m, time;
    static int[][] arr;
    static boolean chess = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        time = 0;
        // 치즈 탐색
        while (chess){
            chess = false;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++){
                for (int j= 0; j <m;j++){
                    if(arr[i][j] == -1) arr[i][j] = 1;
                }
            }
            bfs(0,0);
            if (chess) time++;
        }
        System.out.println(time);
    }
    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[0];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx] && arr[ny][nx] == 0){
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }else if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx] && arr[ny][nx] == 1){
                    arr[ny][nx] = -1;
                    chess = true;
                }else if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx] && arr[ny][nx] == -1){
                    arr[ny][nx] = 0;
                    visited[ny][nx] = true;
                    chess = true;
                }
            }
        }
    }
}