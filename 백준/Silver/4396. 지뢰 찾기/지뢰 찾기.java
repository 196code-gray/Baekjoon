import java.io.*;
import java.util.*;

class Main{
    static String[][] player, map, result;
    static int[][] score;
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n]; player = new String[n][n]; result = new String[n][n]; score = new int[n][n];
        visited = new boolean[n][n];

        // 지뢰 위치 저장
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) map[i][j] = s[j];
        }
        // 플레이어의 진행상황 저장
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) player[i][j] = s[j];
        }
        boolean end = false;
        // 플레이어가 지뢰를 눌렀는지 확인
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("*") && player[i][j].equals("x")) end = true;
            }
        }
        // 지뢰 주변 숫자 탐색
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j].equals("*") && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (end){ // 지뢰를 밟은 경우
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (map[i][j].equals("*")) result[i][j] = "*";
                    else if (player[i][j].equals("x")) {
                        result[i][j] = String.valueOf(score[i][j]);
                    } else result[i][j] = ".";
                }
            }
        }
        else {
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (player[i][j].equals("x")) {
                        result[i][j] = String.valueOf(score[i][j]);
                    } else result[i][j] = ".";
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j= 0; j < n; j++){
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 8; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (isBoundary(nx, ny) && !visited[nx][ny] && map[nx][ny].equals("*")){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
                if (isBoundary(nx, ny) && map[nx][ny].equals(".")){
                    score[nx][ny]++;
                }
            }
        }
    }
    private static boolean isBoundary(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}
