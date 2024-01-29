import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken()); int r = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][n];
        for (int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int group = 0; int ans = 0;
        while (true){
            group = 0;
//            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (!visited[i][j]){
                        Queue<int[]> q = new LinkedList<>();
                        visited[i][j] = true;
                        q.offer(new int[]{i, j});
                        int sum = a[i][j];
                        List<int[]> list = new ArrayList<>();
                        list.add(new int[]{i, j});

                        while (!q.isEmpty()){
                            int[] now = q.poll();
                            for (int k = 0; k < 4; k++){
                                int nx = dx[k] + now[0];
                                int ny = dy[k] + now[1];

                                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]
                                        && Math.abs(a[nx][ny] - a[now[0]][now[1]]) >= l && Math.abs(a[nx][ny] - a[now[0]][now[1]]) <= r){
                                    q.offer(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                    sum += a[nx][ny];
                                    list.add(new int[]{nx, ny});
                                }
                            }
                        }
                        if (list.size() > 1){
                            int result = sum / list.size();
                            for (int[] now : list) {
                                a[now[0]][now[1]] = result;
                            }
                            group++;
                        }
                    }
                }
            }
            if (group == 0) break;
            else ans++;
        }
        System.out.println(ans);
    }
}