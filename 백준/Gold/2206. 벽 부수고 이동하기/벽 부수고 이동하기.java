import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int n,m;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i =0; i < n; i++){
            String s = br.readLine();
            for (int j= 0; j < m; j++){
                map[i][j] = s.charAt(j);
            }
        }
                if (n == 1 && m == 1){
            System.out.println(1);
            System.exit(0);
        }

        System.out.println(BFS());
    }
    static int BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        int[][][] visit = new int[2][n][m];  // 벽을 부수고 지나가는 경우 || 벽을 부수지 않고 지나가는 경우
        visit[0][0][0] = 1; // 출발지

        while (true){
            int[] now = q.poll();
            int w = now[0];
            int x = now[1];
            int y = now[2];

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] == '0'){
                    if (visit[w][nx][ny] == 0){
                        q.offer(new int[]{w, nx, ny});
                        visit[w][nx][ny] = visit[w][x][y] + 1;
                        if (nx == n -1 && ny == m -1){ // 끝지점 도착
                            return visit[w][nx][ny];
                        }
                    }
                }
                else {
                    if (w == 0){
                        if (visit[1][nx][ny] == 0){
                            q.offer(new int[]{1, nx, ny});
                            visit[1][nx][ny] = visit[0][x][y] + 1;
                            if (nx == n -1 && ny == m -1){ // 끝지점 도착
                                return visit[w][nx][ny];
                            }
                        }
                    }
                }
            }
            if (q.isEmpty()) return -1;
        }
    }
}