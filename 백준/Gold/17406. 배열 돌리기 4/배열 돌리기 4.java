import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, min = Integer.MAX_VALUE;
    static int[][] map, change, turn;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m]; change = new int[n][m]; turn = new int[k][3];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j= 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            turn[i][0] = Integer.parseInt(st.nextToken()) -1;
            turn[i][1] = Integer.parseInt(st.nextToken()) -1;
            turn[i][2] = Integer.parseInt(st.nextToken());
        }
        dfs(0, new int[k], new boolean[k]);
        System.out.println(min);
    }
    static void dfs(int depth, int[] order, boolean[] visited){
        if (depth == k){
            arrMin(order);
            return;
        }
        for (int i = 0; i < k; i++){
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                dfs(depth + 1, order, visited);
                visited[i] = false;
            }
        }
    }
    static void arrMin(int[] time){
        for (int i = 0; i < n; i++){
            for (int j= 0; j < m; j++){
                change[i][j] = map[i][j];
                
            }
            
        }

            for (int i = 0; i < k; i++){    // 현재 순서에 맞는 r,c,s 값 꺼냄
                int r = turn[time[i]][0];
                int c = turn[time[i]][1];
                int S = turn[time[i]][2];

                for (int s = 1; s <= S; s++) {
                    // 맨 위
                    int upRigth = change[r - s][c + s];
                    for (int j = c + s; j > c - s; j--) {
                        change[r - s][j] = change[r - s][j - 1];
                    }

                    // 오른쪽
                    int sideRigth = change[r + s][c + s];
                    for (int j = r + s; j > r - s; j--) {
                        change[j][c + s] = change[j - 1][c + s];
                    }
                    change[r - s + 1][c + s] = upRigth;

                    // 아래
                    int sidedown = change[r + s][c - s];
                    for (int j = c - s; j < c + s; j++) {
                        change[r + s][j] = change[r + s][j + 1];
                    }
                    change[r + s][c + s -1] = sideRigth;

                    // 왼쪽
                    for (int j = r - s; j < r + s - 1; j++) {
                        change[j][c - s] = change[j + 1][c - s];
                    }
                    change[r + s - 1][c - s] = sidedown;
                }
            }
        int[] sum = new int[n];
        // 행마다 더해주기
        for (int q = 0; q < n; q++){
            for (int a = 0; a < m; a++){
                sum[q] += change[q][a];
            }
        }
        for (int  w = 0; w < n; w++) min = Math.min(sum[w], min);
    }
}