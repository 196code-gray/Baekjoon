import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;   // 지도의 크기
    static int[] dx = {0, -1, 0, 1};    // 좌 우
    static int[] dy = {-1, 0, 1, 0};    // 앞 뒤
    static boolean[][] visited;     // 방문 여부
    static int[] apart = new int[25 * 25];     // 아파트 단지 저장
    static int count;   // 단지 수
    static int[][] arr;     // 지도 저장
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            String map = st.nextToken();
            for (int j = 0; j < n; j++) {
                arr[i][j] = map.charAt(j) - '0';
            }
        }
        count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 지도가 1이면서 방문하지 않은 곳이라면 탐색
                if (arr[i][j] == 1 && !visited[i][j]) {
                    // 단지 추가
                    count++;
                    DFS(i, j);
                }
            }
        }
        Arrays.sort(apart);
        System.out.println(count);
        for (int i = 0; i < apart.length; i++) {    // 자례대로 단지내 집의 수 출력
            if (apart[i] == 0) continue;
                else System.out.println(apart[i]);

        }
    }

    private static void DFS(int x, int y) {
        // 방문 여부 체크
        visited[x][y] = true;
        // 단지 내의 집 추가
        apart[count]++;
        for (int i = 0; i < 4; i++) {   // 상하좌우 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && n > nx && n > ny) {
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }
}