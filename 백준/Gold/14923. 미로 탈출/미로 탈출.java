import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][][] visit;
    static int N, M, Hx, Hy, Ex, Ey;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; visit = new boolean[2][N][M];
        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken())-1; Hy = Integer.parseInt(st.nextToken()) -1;
        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken()) -1; Ey = Integer.parseInt(st.nextToken()) -1;

        for (int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
    }
    static void BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, Hx, Hy, 0});
        visit[0][Hx][Hy] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int magic = now[0]; int x = now[1]; int y = now[2];

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 탈출 지점 도착한 경우
                if (nx == Ex && ny == Ey){
                    System.out.println(now[3] + 1);
                    return;
                }

                if (magic == 1){
                    if (visit[1][nx][ny] || map[nx][ny] == 1) continue;

                    q.offer(new int[]{1, nx, ny, now[3] + 1});
                    visit[1][nx][ny] = true;
                } else {
                    if (visit[0][nx][ny]) continue;
                    if (map[nx][ny] == 1) {
                        q.offer(new int[]{1, nx, ny, now[3] + 1});
                        visit[1][nx][ny]= true;
                    } else {
                        q.offer(new int[]{0, nx, ny, now[3] + 1});
                        visit[0][nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}