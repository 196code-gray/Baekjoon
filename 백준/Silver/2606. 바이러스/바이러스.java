import java.util.*;

public class Main {
    // 경로 저장할 2차원 배열
    static int[][] map;
    // 탐색 여부를 체크한다.
    static boolean[] check;
    static int n, m, v; // 정점, 간선, 시작
    static int count; // 바이러스 수

    public static int dfs (int i) {
        check[i] = true; // 방문을 했으니 true로 변경.

        for(int j =1; j <= n; j++) {
            if(map[i][j] == 1 && check[j] == false) {
                count++;
                dfs(j);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        v = 1; // 시작 번호
        map = new int[n+1][n+1];
        check = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            map[first][second] = map[second][first] = 1;
        }
        System.out.println(dfs(1));
        scanner.close();
        }
}
