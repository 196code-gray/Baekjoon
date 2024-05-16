import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n, m, r;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Math.min(n, m) / 2; // 내부 배열 개수

        int N = n;
        int M = m;
        for (int i = 0; i < cnt; i++) {
            turn(i, r % ((N * 2) + (M * 2) - 4)); // 현재 시작점, 현재 배열의 개수
            N -= 2; // 끝나면 내부 배열 크기 -2로 줄어듬
            M -= 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void turn(int s, int len) {
        for (int i = 0; i < len; i++){
            int start = arr[s][s];
            int row = s;
            int colum = s;

            int k = 0;
            while (k < 4){
                int nx = row + dx[k];
                int ny = colum + dy[k];

                if (nx == s && ny == s) break;
                if (s <= nx && nx < n - s && s <= ny && ny < m -s){
                    arr[row][colum] = arr[nx][ny];
                    row = nx;
                    colum = ny;
                }
                else k++;
            }
            arr[s + 1][s] = start;
        }
    }
}