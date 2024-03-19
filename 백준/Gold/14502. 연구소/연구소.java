import java.util.*;
import java.io.*;

public class Main {
    static int[][] map, copy;
    static int n,m, ans;
    static boolean[][] visit, vv;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][m]; ans = 0; vv = new boolean[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j= 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); // 입력받기
            }
        }

        dfs(0, 0,0); // 현재 깊이, 행, 열
        System.out.println(ans);
    }
    static void dfs(int depth, int x, int y){
        if (depth == 3){ // 벽을 만들면
            virous();
            return;
        }
        for (int i = x; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] != 0 || vv[i][j]) continue;
                map[i][j] = 1; // 벽으로 변경
                vv[i][j] = true;
                dfs(depth + 1, i, j);
                vv[i][j] = false;
                map[i][j] = 0;  // 다시 빈칸으로
            }
        }
    }
    static void virous(){
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[n][m];
        copy = new int[n][m];
        // 배열 복사
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) copy[i][j] = map[i][j];
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (copy[i][j] != 2 || visit[i][j]) continue;
                q.offer(new int[]{i, j});
                visit[i][j] = true;

                while (!q.isEmpty()){
                    int[] now = q.poll();

                    for (int k = 0; k < 4; k++){
                        int nx = dx[k] + now[0];
                        int ny = dy[k] + now[1];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || copy[nx][ny] != 0) continue;
                        q.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                        copy[nx][ny] = 2; // 바이러스 퍼짐
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (copy[i][j] != 0) continue;
                count++;
            }
        }
        ans = Math.max(ans, count);
    }
}