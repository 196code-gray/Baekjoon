import java.io.*;
import java.util.*;

public class Main {
    static int[][] home;
    static boolean [][] visited;
    static int ans, n;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        home = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (home[n -1][n -1] == 1) {
            System.out.println(0);
            return;
        }
        visited = new boolean[n][n];
        ans = 0;
        bfs();
        System.out.println(ans);
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1, 0});
        visited[0][1] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            if (now[0] == n -1 && now[1] == n -1) ans++;

            for (int dis = 0; dis < 3; dis++){
                int nx = dx[dis] + now[0];
                int ny = dy[dis] + now[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (now[2] == 0){
                    if (dis == 1) continue;
                }
                if (now[2] == 1){
                    if (dis == 0) continue;
                }

                if (home[nx][ny] != 1){
                    if (dis == 2 && home[nx][ny -1] != 1 && home[nx -1][ny] != 1){
                        q.offer(new int[]{nx, ny, dis});
                        visited[nx][ny] = true;
                    }
                    else if (dis != 2){
                        q.offer(new int[]{nx, ny, dis});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}