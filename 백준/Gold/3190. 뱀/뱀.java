import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int n, time, headx, heady, dir, k;
    static Queue<int[]> q;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        time = 0;
        n = Integer.parseInt(br.readLine());
        headx = 0; heady = 0; dir = 0;
        map = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        q = new ArrayDeque<>();
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1; // 사과
        }
        int m = Integer.parseInt(br.readLine());
        q.offer(new int[]{0, 0});
        map[0][0] = -1;
        while (m --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken()); // 초
            String dist = st.nextToken(); // 방향
            while (time < second) {
                headx += dx[dir];
                heady += dy[dir];
                time++;

                if (headx < 0 || heady < 0 || headx >= n || heady >= n) { // 벽에 부딪힐 경우
                    System.out.println(time);
                    return;
                }
                q.offer(new int[]{headx, heady});
                if (map[headx][heady] == -1) { // 꼬리에 부딪힐 경우
                    System.out.println(time);
                    return;
                }
                if (map[headx][heady] == 1) { // 사과를 먹은 경우
                    map[headx][heady] = -1;
                    continue;
                }
                map[headx][heady] = -1; // 꼬리 머리로 당겨오기
                int[] now = q.poll();
                int x = now[0]; int y = now[1];
                map[x][y] = 0;
            }

            if (dist.equals("L")) {
                dir--;
                if (dir == -1) dir = 3;
            }
            if (dist.equals("D")) {
                dir++;
                if (dir == 4) dir = 0;
            }
        }
        while (true) {
            headx += dx[dir];
            heady += dy[dir];
            time++;
            if (headx < 0 || heady < 0 || headx >= n || heady >= n) break;

            q.offer(new int[]{headx, heady});
            if (map[headx][heady] == -1) break;

            if (map[headx][heady] == 1) {
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