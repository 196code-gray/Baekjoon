import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int minMove;
    private static int[][] dist;
    private static Point[] list;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
         br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
             st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            char[][] map = new char[h][w];
            list = new Point[11]; // 먼지의 갯수 최대 10개, 로봇청소기
            int dust_cnt = 1;
            for (int i = 0; i < h; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input[j];
                    if (input[j] == 'o') {
                        list[0] = new Point(i, j);
                    } else if (input[j] == '*') { // 먼지
                        list[dust_cnt++] = new Point(i, j);
                    }
                }
            }
            process(map, w, h, dust_cnt);
            System.out.println(minMove);
        }
    }

    private static void process(char[][] map, int w, int h, int dust_cnt) {
        minMove = Integer.MAX_VALUE;
        dist = new int[dust_cnt + 1][dust_cnt + 1];
        // 청소기와 먼지, 먼지와 먼지의 모든 거리 저장
        for (int i = 0; i < dust_cnt; i++) {
            for (int j = i + 1; j < dust_cnt; j++) {
                int res = BFS(map, w, h, list[i], list[j]);
                if (res == -1) { // 도달 불가
                    minMove = -1;
                    return;
                } else { // 양방향 저장
                    dist[i][j] = dist[j][i] = res;
                }
            }
        }

        boolean[] selected = new boolean[dust_cnt];

        //  모든 거리 순회
        permutation(0, 0, 0, dust_cnt, selected);
    }

    private static void permutation(int idx, int cnt, int sum, int dust_cnt, boolean[] selected) {
        if (cnt == dust_cnt - 1) { // 모든 곳 방문
            minMove = minMove < sum ? minMove : sum;
            return;
        }
        for (int i = 1; i < dust_cnt; i++) {
            if (selected[i])
                continue;
            selected[i] = true;
            permutation(i, cnt + 1, sum + dist[idx][i], dust_cnt, selected);
            selected[i] = false;
        }
    }

    private static int BFS(char[][] map, int w, int h, Point src, Point dist) {
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        boolean[][] visited = new boolean[h][w];
        Queue<Point> q = new LinkedList<>();
        q.offer(src);
        visited[src.y][src.x] = true;
        map[src.y][src.x] = '.';

        int move = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) { // 거리별 탐색
                Point current = q.poll();
                int x = current.x;
                int y = current.y;

                if (y == dist.y && x == dist.x) { // 목적지 도달
                    return move;
                }

                for (int d = 0; d < 4; d++) {
                    int next_y = y + dy[d];
                    int next_x = x + dx[d];
                    if (outRange(next_y, next_x, w, h) || visited[next_y][next_x] || map[next_y][next_x] == 'x')
                        continue;
                    q.offer(new Point(next_y, next_x));
                    visited[next_y][next_x] = true;
                }
            }
            move++;
        }

        return -1;
    }

    private static boolean outRange(int next_y, int next_x, int w, int h) {
        return next_y < 0 || next_y >= h || next_x < 0 || next_x >= w;
    }
}