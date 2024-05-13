import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans = Integer.MIN_VALUE;
    static int[][] paper;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());  m = Integer.parseInt(st.nextToken());
        paper = new int[n][m]; visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++){
                paper[i][j] = s[j].charAt(0) - '0';
            }
        }

        DFS(0, 0, 0);
        System.out.println(ans);
    }
    static void DFS(int depth, int num, int now){
        if (depth == n * m) {
            ans = Math.max(ans, now);
            return;
        }

        int r = depth / m;
        int c = depth % m;

        if (visit[r][c]) DFS(depth +1, num, now);
        else {
            // 한 조각만 자르기
            visit[r][c] = true;
            num = num * 10 + paper[r][c];
            DFS(depth + 1, 0, now + num);

            // 세로로 자르기
            int i, next = num;
            for (i = r + 1; i < n; i++) {
                if (visit[i][c]) break; // 이제 세로로 자르지 못하는 경우
                visit[i][c] = true;
                next = next * 10 + paper[i][c];
                DFS(depth + 1, 0, now + next);
            }

            // 세로로 잘랐던 부분 되돌리기
            for (int j = r + 1; j < i; j++) {
                visit[j][c] = false;
            }

            // 가로로 자르기
            next = num;
            for (i = c + 1; i < m; i++) {
                if (visit[r][i]) break;
                visit[r][i] = true;
                next = next * 10 + paper[r][i];
                DFS(depth + 1, 0, now + next);
            }

            // 가로로 자른 부분 되돌리기
            for (int j = c + 1; j < i; j++) {
                visit[r][j] = false;
            }
            visit[r][c] = false;
        }
    }
}