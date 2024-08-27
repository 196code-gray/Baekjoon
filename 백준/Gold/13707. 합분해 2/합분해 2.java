import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] d = new int[5001][5001];

        d[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                d[i][j] = (d[i][j-1] + (i > 0 ? d[i-1][j] : 0)) % 1000000000;
            }
        }
        System.out.println(d[n][k]);
    }
}