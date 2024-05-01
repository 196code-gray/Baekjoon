import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][][] visit;
    static char[][] map;
    static int c1x, c1y, c2x, c2y, h, w, ans = Integer.MAX_VALUE;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());

        visit = new int[4][h][w]; map = new char[h][w];
        q = new LinkedList<>();
        boolean firstC = false;

        // map 입력받기
        for (int i = 0; i < h; i++){
            String[]s =br.readLine().split("");
            for (int j= 0; j < w; j++){
                map[i][j] = s[j].charAt(0);
                if (map[i][j] == 'C'){
                    // C인 경우
                    if (!firstC) {
                        c1x = i;
                        c1y = j;
                        firstC = true;
                    } else {
                        c2x = i;
                        c2y = j;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < h; j++)
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);

        q.offer(new int[]{0, c1x, c1y, -1}); // 첫번째 C로부터 두번째 C까지
        BFS();
        for (int i = 0; i < 4; i++){
            ans = Math.min(ans, visit[i][c2x][c2y]);
        }

        System.out.println(ans);
    }
    static void BFS(){
        boolean [][] v = new boolean[h][w];
        while (!q.isEmpty()){
            int[] now = q.poll();
            int type = now[0];
            int x = now[1];
            int y = now[2];
            int cnt = now[3];

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                int c = cnt;
                if (type != i){
                    if (c != -1){
                        c++;
                    } else c = 0;
                }
                if (c == -1) c =0;

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;

                if (visit[i][nx][ny] <= c || map[nx][ny] == '*') continue;

                q.offer(new int[]{i, nx, ny, c});
                visit[i][nx][ny] = c;
            }
        }
    }
}