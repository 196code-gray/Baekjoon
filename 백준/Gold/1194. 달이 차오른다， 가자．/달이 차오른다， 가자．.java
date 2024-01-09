import java.io.*;
import java.util.*;

public class Main {
    static String[][] map;
    static int[][] save;
    static boolean[][][] visited;
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new String[n][m]; save = new int[n][m];
        visited = new boolean[64][n][m];
        for (int i = 0; i < n; i ++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++){
                map[i][j] = s[j];
                save[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j++){
                if (map[i][j].equals("0")) {
                    save[i][j] = 0;
                    bfs(i, j, 0);
                }
            }
        }
        for (int i = 0; i < save.length; i++) {
            for (int j = 0; j < save[i].length; j++) {
                if (map[i][j].equals("1")) ans = Math.min(ans, save[i][j]);
            }
        }
        System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
    }
    static void bfs(int x ,int y, int depth){
        Queue<int[]> q = new LinkedList<>();
        // 행, 열, 깊이, 열쇠
        q.offer(new int[]{x, y, 0, 0});
        visited[0][x][y] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();

            if (map[now[0]][now[1]].equals("1")) break;

            for (int i = 0; i<4; i++){
                int nx = dx[i]+now[0];
                int ny = dy[i]+now[1];

                if (isBoundary(nx, ny) && !map[nx][ny].equals("#") && !visited[now[3]][nx][ny]){
                    if (map[nx][ny].equals(".") || map[nx][ny].equals("1") || map[nx][ny].equals("0")){
                        q.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                        save[nx][ny] = Math.min(save[nx][ny], now[2] + 1);
                        visited[now[3]][nx][ny] = true;
                    }

                    else if (map[nx][ny].equals("a") || map[nx][ny].equals("b") || map[nx][ny].equals("c") || map[nx][ny].equals("d")
                            || map[nx][ny].equals("e") || map[nx][ny].equals("f")) {
                        int nk = 1 << (map[nx][ny].charAt(0) - 'a');
                        nk = nk | now[3];
                        if (!visited[nk][nx][ny]) {
                            visited[now[3]][nx][ny] = true;
                            visited[nk][nx][ny] = true;
                            q.offer(new int[]{nx, ny, now[2] + 1, nk});
                            save[nx][ny] = Math.min(save[nx][ny], now[2] + 1);
                        }
                    }
                    else if (map[nx][ny].equals("A") || map[nx][ny].equals("B") || map[nx][ny].equals("C") || map[nx][ny].equals("D")
                            || map[nx][ny].equals("E") || map[nx][ny].equals("F")) {
                        int d = 1 << (map[nx][ny].charAt(0) - 'A');
                        if ((now[3] & d) > 0) {
                            visited[now[3]][nx][ny] = true;
                            save[nx][ny] = Math.min(save[nx][ny], now[2] + 1);
                            q.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                        }
                    }
                }
            }
        }
    }
    static boolean isBoundary(int nx, int ny){
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}