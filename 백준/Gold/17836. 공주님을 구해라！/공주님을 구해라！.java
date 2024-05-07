import java.io.*;
import java.util.*;

public class Main {
    static int[][][] visit;
    static int[][] map;
    static int n, m, t;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        visit = new int[2][n][m]; map = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(visit[0][i] ,10000);  // 임의의 큰 수
                Arrays.fill(visit[1][i] ,10000);  // 임의의 큰 수
            }
        }
        BFS();
    }
    static void BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 0});
        visit[0][0][0] = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int gram = now[0]; int x = now[1]; int y = now[2];
            int cnt = now[3];

            if (cnt > t) continue;

            for (int i = 0; i < 4; i++){
                int nx= dx[i] + x;
                int ny = dy[i] + y;

                if (nx == n -1 && ny == m -1){
                    System.out.println(cnt + 1);
                    return;
                }

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[gram][nx][ny] <= cnt + 1) continue;
                if (gram == 1){
                    q.offer(new int[]{gram, nx, ny, cnt + 1});
                    visit[1][nx][ny] = cnt + 1;
                } else {
                    if (map[nx][ny] == 1) continue;
                    if (map[nx][ny] == 2) { // 그람을 얻은 경우
                        q.offer(new int[]{1, nx, ny, cnt+1});
                    }
                    else q.offer(new int[]{gram, nx, ny, cnt + 1});
                    visit[0][nx][ny] = cnt + 1;
                }
            }
        }
        System.out.println("Fail");
    }
}