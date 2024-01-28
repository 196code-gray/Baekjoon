import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][n];

        int ans = Integer.MAX_VALUE;
        int first = 0; int two = 0;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j) a[i][j] = 0;
                else a[i][j] = 100_000;
            }
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) -1;
            int e = Integer.parseInt(st.nextToken()) -1;
            a[s][e] = 2;
            a[e][s] = 2;
        }
        for (int w = 0; w < n; w++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j ++){
                    a[i][j] = Math.min(a[i][j], a[i][w] + a[w][j]);
                }
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j) continue;
                int sum = 0;
                for (int k = 0; k < n; k++){
                    if (k == i || k == j) continue;
                    sum += Math.min(a[i][k], a[j][k]);
                }
                if (ans > sum){
                    first = i + 1;
                    two = j + 1;
                    ans = sum;
                }
            }
        }
        System.out.print(first + " " + two + " " + ans);
    }
}