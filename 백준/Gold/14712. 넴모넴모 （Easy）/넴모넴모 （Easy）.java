import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, cnt;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        map = new int[n][m]; cnt = 0;

        DFS(0, 0);

        System.out.println(cnt);
    }
    static void DFS(int idx, int idy){
        if (idx == n){
            for (int i = 0; i <= n - 2; i++){
                for (int j = 0; j <= m - 2; j++){
                    if (map[i][j] == 1 && map[i][j + 1] == 1 &&
                    map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) return;
                }
            }
            cnt++;
            return;
        }

        int nowy = idy + 1 < m ? idy + 1 : 0;
        int nowx = nowy == 0 ? idx + 1 : idx;

        map[idx][idy] = 1;
        DFS(nowx, nowy);
        map[idx][idy] = 0;
        DFS(nowx, nowy);

    }
}