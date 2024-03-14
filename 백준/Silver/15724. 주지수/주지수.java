import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j= 1; j <= M; j++){
                // 누적합 구하기
                sum[i][j] = sum[i][j -1] + sum[i-1][j] + Integer.parseInt(st.nextToken()) - sum[i-1][j-1];
            }
        }
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (K-->0){
            st  = new StringTokenizer(br.readLine());
            int s1, s2,e1, e2;
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());
            e1 = Integer.parseInt(st.nextToken());
            e2 = Integer.parseInt(st.nextToken());

            sb.append(sum[e1][e2] - sum[s1 -1][e2] - sum[e1][s2 -1] + sum[s1 -1][s2 -1]).append("\n");
        }
        System.out.println(sb);
    }
}