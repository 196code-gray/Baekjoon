import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map, total;
    static int n, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        total = new int[n][n];
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(s[j]);
                total[i][j] = Integer.MAX_VALUE;
            }
        }
        total[0][0] = 0;
        bfs();
        System.out.println(total[n-1][n-1]);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];


                if (isaBoolean(nx, ny) && total[nx][ny] > total[now[0]][now[1]]){
                    if (map[nx][ny] == 1) total[nx][ny] = total[now[0]][now[1]];
                    else total[nx][ny] = total[now[0]][now[1]] + 1;
                    q.offer(new int[]{nx, ny, total[nx][ny]});
                }

            }
        }
    }

    private static boolean isaBoolean(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}