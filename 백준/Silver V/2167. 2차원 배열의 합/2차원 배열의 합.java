import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[][] sum = new int[n + 1][m +1];
        for (int i = 1;i <= n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++){
                // 누접합 구하기
                sum[i][j] = sum[i -1][j] + sum[i][j -1] - sum[i -1][j- 1] + Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (k --> 0){
            st= new StringTokenizer(br.readLine());
            int si, sj, ei, ej;
            si = Integer.parseInt(st.nextToken()); sj = Integer.parseInt(st.nextToken());
            ei = Integer.parseInt(st.nextToken()); ej = Integer.parseInt(st.nextToken());

            sb.append(sum[ei][ej] - sum[ei][sj -1] - sum[si -1][ej] + sum[si -1][sj -1]).append("\n");
        }
        System.out.println(sb);
    }
}