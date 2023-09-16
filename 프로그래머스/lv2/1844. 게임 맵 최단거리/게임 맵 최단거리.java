import java.util.*;
class Solution {
    static int[][] visited;
    static int[] x = {0, -1, 0, 1};
    static int[] y = {1, 0, -1, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];

        BFS(0, 0, maps);
        answer = visited[maps.length -1][maps[0].length -1];

        if (answer == 0) answer = -1;

        return answer;
    }
    public static void BFS(int i, int j, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = 1;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] now = q.remove();
            int dx = now[0];
            int dy = now[1];

            for (int a = 0; a < 4; a++) {
                int nowx = dx + x[a];
                int nowy = dy + y[a];
                if (nowx < 0 || nowx > maps.length -1 || nowy < 0 || nowy > maps[0].length -1) continue;
                if (visited[nowx][nowy] == 0 && maps[nowx][nowy] == 1) {
                    visited[nowx][nowy] = visited[dx][dy] + 1;
                    q.add(new int[]{nowx, nowy});
                }
            }
        }
    }
}