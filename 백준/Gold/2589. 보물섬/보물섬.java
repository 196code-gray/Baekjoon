import java.util.*;
import java.io.*;

public class Main {
    static int n,m,ans;
    static String[][] map;
    static int[] dx = {0,1, 0, -1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        for (int i = 0; i < n; i++){
            map[i] = br.readLine().split("");
        }
        ans = 0;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j++){
                if (map[i][j].equals("L")){
                    bfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        boolean[][] visit = new boolean[n][m];
        visit[x][y] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && map[nx][ny].equals("L")){
                    q.offer(new int[]{nx, ny, now[2] + 1});
                    ans = Math.max(ans, now[2] + 1);
                    visit[nx][ny] = true;
                }
            }
        }
    }
}