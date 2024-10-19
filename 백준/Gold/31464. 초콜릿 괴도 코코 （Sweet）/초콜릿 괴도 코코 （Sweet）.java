import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static int N, M, choco;
    static int[][] map = new int[50][50];
    static List<Pair> ans = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] visit = new int[50][50];
    static int cycle, cnt;

    static void init() {
        cnt = 0;
        cycle = 0;
        for (int y = 1; y <= N; y++) {
            Arrays.fill(visit[y], 0);
        }
    }

    static void dfs(int x, int y, int px, int py) {
        visit[y][x] = 1;
        cnt++;
        for (int d = 0; d <= 3; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == px && ny == py)
                continue;
            if (nx < 1 || N < nx || ny < 1 || N < ny)
                continue;
            if (map[ny][nx] == 0)
                continue;
            if (visit[ny][nx] == 1)
                cycle = 1;
            else
                dfs(nx, ny, x, y);
        }
    }

    static boolean check() {
        init();
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (map[y][x] == 1) {
                    dfs(x, y, -1, -1);
                    return cnt == choco && cycle == 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int y = 1; y <= N; y++) {
            String line = br.readLine();
            for (int x = 1; x <= N; x++) {
                char c = line.charAt(x - 1);
                map[y][x] = (c == '#') ? 1 : 0;
                if (c == '#') {
                    choco++;
                }
            }
        }

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (map[y][x] == 1) {
                    choco--;
                    map[y][x] = 0;
                    if (check()) {
                        ans.add(new Pair(y, x));
                    }
                    map[y][x] = 1;
                    choco++;
                }
            }
        }

        System.out.println(ans.size());
        for (Pair node : ans) {
            System.out.println(node.first + " " + node.second);
        }
    }
}