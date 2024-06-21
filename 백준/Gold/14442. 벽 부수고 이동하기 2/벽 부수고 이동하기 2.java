import java.io.*;
import java.util.*;

public class Main {
    static char[][] map; // 현재 지도 저장
    static int n, m, k;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i =0; i < n; i++){
            String s = br.readLine();
            for (int j= 0; j < m; j++){
                map[i][j] = s.charAt(j);
            }
        }
        if (n == 1 && m == 1){ // 둘 다 1인 경우 시작과 동시에 도착
            System.out.println(1);
            return;
        }

        System.out.println(BFS());
    }
    static int BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visit = new int[k+1][n][m];  // 벽을 k개 부순경우 ~ 벽을 0개 부순경우
        visit[0][0][0] = 1; // 출발에도 개수 카운트

        while (true){
            int[] now = q.poll();
            int w = now[0]; // 벽 상태
            int x = now[1]; // 행
            int y = now[2]; // 열

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] == '0'){ // 빈 칸
                    if (visit[w][nx][ny] == 0){
                        q.offer(new int[]{w, nx, ny});
                        visit[w][nx][ny] = visit[w][x][y] + 1;
                        if (nx == n -1 && ny == m -1){ // 끝지점 도착
                            return visit[w][nx][ny];
                        }
                    }
                }
                else { // 빈칸이 아닐 경우
                    if (w + 1 <= k){
                        if (visit[w + 1][nx][ny] == 0){
                            q.offer(new int[]{w + 1, nx, ny});
                            visit[w+1][nx][ny] = visit[w][x][y] + 1;
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