import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int n;
    static PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2]; // 변경 횟수 오름차순
        }
    });
    static int[][] visit = new int[50][50], map = new int[50][50];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++){
                map[i][j] = s[j].charAt(0) - '0';
            }
        }

        for (int i = 0; i < n; i++) Arrays.fill(visit[i], 10000);

        BFS();
    }
    static void BFS(){
        q.offer(new int[]{0, 0, 0});
        visit[0][0] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x= now[0];
            int y =now[1];
            int cnt =now[2];

            if (x == n -1 && y == n -1){
                System.out.println(cnt);
                return;
            }

            for (int i = 0;i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                int num = map[nx][ny] == 0 ? cnt + 1 : cnt;
                if (visit[nx][ny] <= num) continue;

                q.offer(new int[]{nx, ny, num});
                visit[nx][ny] = num;
            }
        }
    }
}