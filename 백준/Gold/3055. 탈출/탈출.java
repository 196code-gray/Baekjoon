import java.io.*;
import java.util.*;

public class Main {
    static int[][] water;
    static char[][] forest;
    static int R,C;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1,0,-1,0};
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]); C = Integer.parseInt(s[1]);

        q = new LinkedList<>();
        water = new int[R][C]; forest = new char[R][C];
        int x,y; x = y = 0;

        for (int i = 0; i < R; i++){
            s = br.readLine().split("");
            for (int j = 0; j < C; j++){
                Arrays.fill(water[i], 1000);
                forest[i][j] = s[j].charAt(0);
                if (forest[i][j] == '*') q.offer(new int[]{i, j, 0}); // 물인 경우
                else if (forest[i][j] == 'S') {  // 출발지 경우
                    x = i;
                    y = j;
                }
            }
        }

        waterMove();
        q.offer(new int[]{x, y, 0});
        BFS();
    }
    static void waterMove(){
        boolean[][] visit = new boolean[R][C];
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1];
            visit[x][y] = true;

            for (int i = 0; i< 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visit[nx][ny] || forest[nx][ny] == 'X' || forest[nx][ny] == 'D') continue;

                q.offer(new int[]{nx, ny, now[2] + 1});
                visit[nx][ny] = true;
                water[nx][ny] = now[2] + 1;
            }
        }
    }
    static void BFS(){
        boolean[][] visit = new boolean[R][C];
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1];

            for (int i= 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                // 탈출
                if (forest[nx][ny] == 'D') {
                    System.out.println(now[2] + 1);
                    return;
                }
                if (visit[nx][ny] || forest[nx][ny] == 'X' || water[nx][ny] <= now[2] + 1) continue;

                q.offer(new int[]{nx, ny, now[2] + 1});
                visit[nx][ny] = true;
            }
        }
        System.out.println("KAKTUS");
    }
}