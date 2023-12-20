import java.io.*;
import java.util.*;

public class Main {
    static int n, m, time, chess, chessCount;   // 세로, 가로, 시간, 총 치즈, 남은 치즈
    static int[][] arr;     // 판의 크기
    static boolean[][] visited;     // 방문배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) chess++;
            }
        }
        time = chessCount = 0;
        while(chess != 0) {
            chessCount = chess;
            time++;
            visited = new boolean[n][m];
            bfs();
        }

        System.out.println(time);
        System.out.println(chessCount);

    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i=0;i<4;i++){
                int nx = now[0] + dx[i];
                int ny = now[1]+dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx]){
                    if (arr[ny][nx] == 0) {
                        q.offer(new int[]{nx, ny});
                        visited[ny][nx] = true;
                    } else {
                        arr[ny][nx] = 0;
                        visited[ny][nx] = true;
                        chess--;
                    }
                }
            }
        }
    }
}