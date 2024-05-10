import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};
    private static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++){
                map[i][j] = s[j].charAt(0) - '0';
            }
        }

        visit = new boolean[n][m];
        BFS();
    }
    static void BFS(){
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];  // 벽을 최소로 부순 값부터 정렬
            }
        });
        q.offer(new int[]{0, 0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()){
            int[] now = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx <0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visit[nx][ny]) continue;

                if (nx == n -1 && ny == m -1) {
                    System.out.println(now[2]);
                    return;
                }

                if (map[nx][ny] == 1)
                    q.offer(new int[]{nx, ny, now[2] + 1});
                else q.offer(new int[]{nx, ny, now[2]});
                visit[nx][ny] = true;
            }
        }
                System.out.println(0);
    }
}