import java.util.*;
import java.io.*;

public class Main {
    static int[][] square;
    static int n,m,k;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1,0, -1, 0};
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());

         square = new int[n + 1][m + 1];
         for (int i = 0; i < k; i++){
             st = new StringTokenizer(br.readLine());
             int x1 = Integer.parseInt(st.nextToken());
             int y1 = Integer.parseInt(st.nextToken());
             int x2 = Integer.parseInt(st.nextToken());
             int y2 = Integer.parseInt(st.nextToken());

             for (int j = y1; j < y2; j++){
                 for (int K = x1; K < x2; K++){
                     square[j][K] = 1;
                 }
             }
         }
         int count = 0;
         List<Integer> l = new ArrayList<>();
         visit = new boolean[n + 1][m +1];
         for (int i = 0; i < n; i++){
             for (int j = 0; j < m; j++){
                 if (square[i][j] != 1 && !visit[i][j]){
                     count++;
                     l.add(BFS(i, j));
                 }
             }
         }
        System.out.println(count);
         Collections.sort(l);
        for (Integer i : l) {
            System.out.print(i + " ");
        }
    }
    static int BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        int ans = 1;

        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && square[nx][ny] == 0){
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}