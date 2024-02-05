import java.io.*;
import java.util.*;

public class Main {
    static int[][] now = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n;
    static double[] robot;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        robot = new double[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) robot[i] = Integer.parseInt(st.nextToken()) * 0.01;
        visited = new boolean[29][29];
        double ans = dfs(14, 14, 0);
        System.out.println(ans);
    }
    static double dfs(int x, int y, int depth){
        if (depth == n) return 1.0;

        visited[x][y] = true;
        double ans = 0.0;

        for (int i = 0; i < 4; i++){
            int nx = now[i][0] + x;
            int ny = now[i][1] + y;

            if(visited[nx][ny])continue;
            ans = ans + robot[i] * dfs(nx, ny, depth+1);
        }
        visited[x][y] = false;
        return ans;
    }
}