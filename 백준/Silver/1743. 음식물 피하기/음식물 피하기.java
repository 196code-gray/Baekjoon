import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k;
    static int[][] school;
    static boolean[][] visited;
    static int size;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        school = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        size = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            school[y][x] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (school[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }
        System.out.println(size);
    }
    static void BFS(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;
        int num = 1;
        while (!q.isEmpty()) {
            int[] now = q.remove();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[1];
                int ny = dy[i] + now[0];
                if (nx > 0 && ny > 0 && nx <= m && ny <= n && school[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    num++;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        size = Math.max(size, num);
    }
}