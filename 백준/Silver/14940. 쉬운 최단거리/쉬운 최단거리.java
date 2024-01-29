import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        int[][] map;
        int[] end;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][m]; end  = new int[2];
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0;j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                    ans[i][j] = 0;
                }
                else if (map[i][j] == 0) ans[i][j] = 0;
                else ans[i][j] = -1;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{end[0], end[1], 0});
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && ans[nx][ny] == -1){
                    ans[nx][ny] = now[2] + 1;
                    q.offer(new int[]{nx, ny, now[2] + 1});

                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i =0;i < n; i++){
            for (int j = 0; j < m; j++)
                bw.write(ans[i][j]+" ");
            bw.write("\n");
        }
        bw.close();
    }
}