import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int count, size;     // 그림 개수, 그림 넓이
    static int[] dx = {0, 1, 0 ,-1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0; size = 0;
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        if (count == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(count);
            System.out.println(size);
        }
    }
    static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        int now = 1;
        q.add(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] num = q.poll();
            for (int i = 0;i<4;i++) {
                int nx = dx[i] + num[1];
                int ny = dy[i] + num[0];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx] && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                    now++;
                }
            }
        }
         size = Math.max(size, now);
    }
}