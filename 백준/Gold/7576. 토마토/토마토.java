import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m, ans;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visited[i][j] && arr[i][j] == 1){
                    q.add(new int[]{i, j});
                }
            }
        }
        ans = bfs();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (arr[i][j] == 0){
                    ans = -1;
                    break;
                }
            }
        }
        if(ans == 0) System.out.println(ans);
        else System.out.println((ans == -1) ? -1 : ans -1);
      }
      static int bfs(){
          int day = 0;

          while(!q.isEmpty()){
              int[] now = q.poll();
              visited[now[0]][now[1]] = true;
              for (int i = 0; i < 4; i++){
                  int nx = dx[i] + now[1];
                  int ny = dy[i] + now[0];

                  if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx] && arr[ny][nx] == 0) {
                      arr[ny][nx] = arr[now[0]][now[1]] + 1;
                      visited[ny][nx] = true;
                      q.offer(new int[]{ny, nx});
                  }
                  if (nx >= 0 && ny >= 0 && nx < m && ny < n && day < arr[ny][nx]) day = arr[ny][nx];
              }
          }
          return day;
      }
}