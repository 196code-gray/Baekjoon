    import java.io.*;
    import java.util.*;

    public class Main {
        static boolean[] visited;
        static char[][] arr;
        static int ans, r,c;
         static int[] dx = {0, 1, 0, -1};
         static int[] dy = {1, 0, -1, 0};

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new char[r][c];
            visited = new boolean[26];

            for (int i = 0; i < r; i++){
                arr[i] = br.readLine().toCharArray();
            }

            ans = 1;
            dfs(0,0, 0);
            System.out.println(ans);
        }

        private static void dfs(int x, int y, int depth) {
            if (visited[arr[x][y] - 65]) {
                ans = Math.max(ans, depth);
                return;
            }

            visited[arr[x][y] - 65] = true;
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx >= 0 && ny >= 0 && nx < r && ny < c) dfs(nx, ny, depth + 1);
            }
            visited[arr[x][y] - 65] = false;

        }
    }