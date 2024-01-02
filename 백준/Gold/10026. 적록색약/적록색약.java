import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int n, ans, ans2;
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        for (int i = 0; i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] c = st.nextToken().toCharArray();
            for (int j = 0; j < n; j++){
                arr[i][j] = String.valueOf(c[j]);
            }
        }
        ans = ans2 = 0;
        visited = new boolean[n][n];
        // 적록색약이 아닌 사람 탐색
        for (int i = 0; i < n;i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j].equals("R") && !visited[i][j]){
                    ans++;
                    bfs(i, j, "R");

                } else if (arr[i][j].equals("G") && !visited[i][j]){
                    ans++;
                    bfs(i, j, "G");
                } else if(arr[i][j].equals("B")&& !visited[i][j]) {
                    ans++;
                    bfs(i, j, "B");
                }
            }
        }
        visited = new boolean[n][n];
        // 적록색약이 있는 사람 탐색
        for (int i = 0; i < n;i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j].equals("R") || arr[i][j].equals("G")) {
                    if (!visited[i][j]){
                    ans2++;
                    bfs1(i, j, "R");
                }} else if(arr[i][j].equals("B") && !visited[i][j]) {
                    ans2++;
                    bfs1(i, j, "B");
                }
            }
        }
        System.out.println(ans + " " + ans2);
    }

    private static void bfs1(int y, int x, String s) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[0];
                if (s.equals("R") || s.equals("G")) {
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (!visited[ny][nx] && arr[ny][nx].equals("R")) {
                            q.offer(new int[]{ny, nx});
                                visited[ny][nx] = true;
                        }
                        else if (!visited[ny][nx] && arr[ny][nx].equals("G")) {
                            q.offer(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                } else if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx] && arr[ny][nx].equals(s)) {
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }

            }
        }
    }
    private static void bfs(int y, int x, String s) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[0];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx] && arr[ny][nx].equals(s)){
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}