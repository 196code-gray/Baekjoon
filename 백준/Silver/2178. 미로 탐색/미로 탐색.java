import java.io.*;
import java.util.*;

    public class Main {
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};
        static int[][] arr;
        static boolean[][] visit;
        static int n, m;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(a.substring(j, j + 1));
                }
            }
            bfs(0, 0);
            System.out.println(arr[n -1][m -1]);
        }
        static void bfs ( int s, int e) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {s, e});
            visit[s][e] = true;

            while (!q.isEmpty()) {
                int now[] = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = now[0] + dx[i];
                    int y = now[1] + dy[i];
                    if (x >= 0 && y >= 0 && x < n && y < m) {
                        if (arr[x][y] != 0 && !visit[x][y]) {
                            visit[x][y] = true;
                            arr[x][y] = arr[now[0]][now[1]] + 1;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }

        }
    }