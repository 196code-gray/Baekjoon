import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] num = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(s[j]);
            }
        }
        int max = Math.min(n, m);   // 만들 수 있는 정사각형의 최대 크기
        // 정사각형 구하기
        while (max > 1) {
            for (int i = 0; i <= n - max; i++) {   // 행만큼
                for (int j = 0; j <= m - max; j++) {    // 열만큼
                    if (num[i][j] == num[i][j + max - 1] && num[max + i - 1][j] == num[i + max - 1][j + max - 1] && num[i][j] == num[i + max - 1][j + max - 1]) {
                        System.out.println(max * max);
                        return;
                    }
                }
            }
            max--;
        }
        System.out.println(max * max);
    }
}