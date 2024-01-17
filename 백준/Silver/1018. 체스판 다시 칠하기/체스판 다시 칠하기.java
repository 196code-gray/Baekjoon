import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        String[][] map = new String[n + 1][m + 1];
        for (int i = 1; i <= n; i++){
            String[] s= br.readLine().split("");
            for (int j = 1; j <= m; j++){
                map[i][j] = s[j -1];
            }
        }
        for (int i = 1; i <= n -7; i++){
            for (int j = 1; j <= m -7; j++){
                for (int q = 0; q < 2; q++) {
                    String white = (q == 0) ? "W" : "B";
                    int count = 0;

                    for (int k = i; k < i + 8; k++) {
                        for (int p = j; p < j + 8; p++) {
                            if (!map[k][p].equals(white)) count++;
                            white= white.equals("W") ? "B" : "W";
                        }
                        white= white.equals("W") ? "B" : "W";
                    }
                    ans = Math.min(ans, count);
                }
            }
        }
        System.out.println(ans);
    }
}