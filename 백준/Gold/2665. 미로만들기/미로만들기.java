import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] isVisited;

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }


        bfs01();
    }
    static void bfs01() {

        ArrayDeque<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[] { 0, 0, 0 });
        while (!q.isEmpty()) {

            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int w = temp[2];
            if (y == N-1 && x == N-1) {
                System.out.println(w);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny > N-1 || nx > N-1)
                    continue;
                if (isVisited[ny][nx])
                    continue;
                isVisited[ny][nx] = true;
                if (map[ny][nx] == '0') {
                    q.add(new int[] { ny, nx, w + 1 });
                } else {
                    q.push(new int[] { ny, nx, w });
                }
            }
        }
    }
}