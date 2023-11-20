import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;    // 지도 저장 배열
    static boolean[][] visited;       // 방문 여부
    static int w;
    static int h;
    static int count;        // 부모 저장 배열
    static int[] dx = {1, -1, -1, 1};
    static int[] dy = {-1, 1, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            arr = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];
            count = 0;
            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        count++;
                        DFS(i, j, arr);
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void DFS(int y, int x, int[][] arr) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (ny <= h && nx <= w && ny >= 0 && nx >= 0 && arr[ny][nx] == 1 && !visited[ny][nx]) {
                DFS(ny, nx, arr);
            }
            else if (ny <= h && nx <= w && ny >= 0 && nx >= 0 && arr[y][nx] == 1 && !visited[y][nx]) {
                DFS(y, nx, arr);
            } else if (ny <= h && nx <= w && ny >= 0 && nx >= 0 && arr[ny][x] == 1 && !visited[ny][x]) {
                DFS(ny, x, arr);
            }
        }
    }
}