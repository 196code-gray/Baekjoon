import java.io.*;
import java.util.*;

class Main{
    static int[][] map, virus;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m]; map = new int[n][m];

        for (int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
//        dfs(0);
        int mul = n * m;
        for (int w1 = 0; w1 < mul - 2; w1++) {
            if (map[w1 / m][w1 % m] != 0)
                continue;
            map[w1 / m][w1 % m] = 1;
            for (int w2 = w1 + 1; w2 < mul - 1; w2++) {
                if (map[w2 / m][w2 % m] != 0)
                    continue;
                map[w2 / m][w2 % m] = 1;
                for (int w3 = w2 + 1; w3 < mul; w3++) {
                    if (map[w3 / m][w3 % m] != 0)
                        continue;
                    map[w3 / m][w3 % m] = 1;

                    ///////
                    bfs();
                    ///////

                    map[w3 / m][w3 % m] = 0;
                }
                map[w2 / m][w2 % m] = 0;
            }
            map[w1 / m][w1 % m] = 0;
        }
        System.out.println(ans);
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i= 0; i < n; i ++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        virus = new int[n][m];
        // 바이러스를 저장할 새로운 배열 생성
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                virus[i][j] = map[i][j];
            }
        }
        // 바이러스일 경우 큐에 넣어줌.
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()){
            int[] now = q.poll();
            visited[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (isBoundary(nx, ny) && !visited[nx][ny] && virus[nx][ny] == 0){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    virus[nx][ny] = 2;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (virus[i][j] == 0) max++;
            }
        }
        ans = Math.max(max, ans);
    }
    private static boolean isBoundary(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
