import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = 0;
        int n = Integer.parseInt(br.readLine());
        int headx = 0; int heady = 0; int dir = 0;
        int[][] map = new int[n][n];
        int[] dx = {0, 1, 0,-1};
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;
            map[r][c] = 1;
        }
        int m = Integer.parseInt(br.readLine());
        q.offer(new int[]{0, 0});
        map[0][0] = -1;
        while (m --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            while (time < x) {
                headx += dx[dir];
                heady += dy[dir];
                time++;

                if (headx < 0 || heady < 0 || headx >= n || heady >= n) {
                    System.out.println(time);
                    return;
                }
                q.offer(new int[]{headx, heady});
                if (map[headx][heady] == -1) {
                    System.out.println(time);
                    return;
                }
                if (map[headx][heady] == 1) {
                    map[headx][heady] = -1;
                    continue;
                }
                map[headx][heady] = -1;
                int[] now = q.poll();
                map[now[0]][now[1]] = 0;
            }

            if(c.equals("L")){
                dir--;
                if (dir == -1) dir = 3;
            }
            if (c.equals("D")){
                dir++;
                if (dir == 4) dir = 0;
            }
        }
        while (true){
            headx += dx[dir];
            heady += dy[dir];
            time++;
            if (headx < 0 || heady < 0 || headx >= n || heady >= n) break;

            q.offer(new int[]{headx, heady});
            if (map[headx][heady] == -1) break;

            if (map[headx][heady] == 1){
                map[headx][heady] = -1;
                continue;
            }
            map[headx][heady] = -1;
            int[] now = q.poll();
            map[now[0]][now[1]] = 0;
        }
        System.out.println(time);
    }
}
