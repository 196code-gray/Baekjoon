import java.io.*;
import java.util.*;

public class Main {
    static char[][] map; // 현재 지도 저장
    static PriorityQueue<int[]> q;
    static int h, w;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] visit;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2]; // 문을 연 횟수 오름차순
            }
        });

        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken()); w = Integer.parseInt(st.nextToken());
            map = new char[h+2][w+2];

            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            List<int[]> list = new ArrayList<>();
            for (int i = 1; i <= h; i++){
                for (int j = 1; j <= w; j++){
                    if (map[i][j] == '$')
                        list.add(new int[]{i, j});
                }
            }

            int[][] first = BFS(list.get(0)[0], list.get(0)[1]); // 첫번째 죄수
            int[][] two = BFS(list.get(1)[0], list.get(1)[1]);  // 두번째 죄수
            int[][] other = BFS(0, 0);  // 상근이(제 3자)

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < h+2; i++){
                for (int j = 0;j < w+2; j++){
                    if (first[i][j] != -1 && two[i][j] != -1 && other[i][j] != -1 && map[i][j] != '*'){
                        int result = first[i][j] + two[i][j] + other[i][j];

                        if (map[i][j] == '#')
                            result -= 2;
                        ans = Math.min(ans, result);
                    }
                }
            }
            System.out.println(ans);
        }
    }
    static int[][] BFS(int sx, int sy){
        q.offer(new int[]{sx, sy, 0});
        visit = new int[h + 2][w + 2];

        for (int[] num : visit)
            Arrays.fill(num, -1);

        visit[sx][sy] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];

            for (int i = 0;i < 4;i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && nx < h + 2 && ny >= 0 && ny < w + 2 && map[nx][ny] != '*' && visit[nx][ny] == -1) {
                    if (map[nx][ny] == '#') {
                        visit[nx][ny] = visit[x][y] + 1;
                        q.offer(new int[]{nx, ny, cnt + 1});
                    } else {
                        visit[nx][ny] = visit[x][y];
                        q.offer(new int[]{nx, ny, cnt});
                    }
                }
            }
        }
        return visit;
    }
}