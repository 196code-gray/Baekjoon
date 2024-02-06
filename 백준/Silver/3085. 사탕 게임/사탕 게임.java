import java.io.*;
import java.util.*;

public class Main {
    static String[][] candy, copy;
    static int ans, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        candy = new String[n][n];
        copy = new String[n][n];
        ans = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                candy[i][j] = s[j];
                copy[i][j] = candy[i][j];   // 그대로 복사
            }
        }

        swap();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                copy[i][j] = candy[i][j + 1];
                copy[i][j + 1] = candy[i][j];
                swap();
                copy[j][i] = candy[j + 1][i];
                copy[j + 1][i] = candy[j][i];
                swap();
            }
        }
        System.out.println(ans);
    }

    static void swap() {
        int count = 1;

        for (int i = 0; i < n; i++) {     // 현재 행에서 먹을 수 있는 같은 사탕의 최대 개수
            count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (copy[i][j].equals(copy[i][j + 1])) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
            ans = Math.max(ans, count);
        }
        for (int i = 0; i < n; i++) {     // 현재 열에서 먹을 수 있는 같은 사탕의 최대 개수
            count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (copy[j][i].equals(copy[j + 1][i])) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
            ans = Math.max(ans, count);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = candy[i][j];
            }
        }
    }
}