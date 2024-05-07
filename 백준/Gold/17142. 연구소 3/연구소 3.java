import java.io.*;
import java.util.*;

public class Main {
    static class Virus{
        int x, y;

        public Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visit;
    static int[][] map, v_arr;
    static int n, m, blank, ans = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Virus> v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][n]; v_arr = new int[m][2]; v = new ArrayList<>();
        blank = 0;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) blank++;
                if (map[i][j] == 2) v.add(new Virus(i ,j));
            }
        }

        if (blank == 0){
            System.out.println(0);
            return;
        }
        DFS(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    static void DFS(int depth, int idx){
        if (depth == m) {
            BFS();
            return;
        }

        for (int i = idx; i < v.size(); i++){
            int x = v.get(i).x;
            int y = v.get(i).y;
            v_arr[depth][0] = x;
            v_arr[depth][1] = y;
            DFS(depth + 1, i + 1);
            visit[x][y]=false;
        }
    }
    static void BFS(){
        int max = 0; int c = 0;
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[n][n];
        for (int i = 0; i < m; i++){
            int x = v_arr[i][0];
            int y = v_arr[i][1];
            q.offer(new int[]{x, y, 0});
            visit[x][y] = true;
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1];
            int cnt = now[2];

            for (int i = 0; i < 4; i++){
                int nx= dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visit[nx][ny] || map[nx][ny] == 1) continue;

                q.offer(new int[]{nx, ny, cnt + 1});
                visit[nx][ny] = true;
                if (map[nx][ny] == 0) {
                    c++;
                    max = Math.max(cnt + 1, max);
                }
            }
        }
        if (blank != c) return;

        ans = Math.min(max, ans);
    }
}