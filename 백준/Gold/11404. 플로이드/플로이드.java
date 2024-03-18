import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] price = new int[n + 1][m + n];
        final int INF = 10_000_000;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++){
            Arrays.fill(price[i], INF);  // 최고값 저장
            price[i][i] = 0; // 자기자신 초기화
        }
        for (int i = 1;i <= m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            price[s][e] = Math.min(p, price[s][e]); // 비용 저장
        }
        // 플로이드 와샬
        for (int k = 1; k <= n; k++){  // 경유지
            for (int i = 1; i <= n; i++){  // 출발지
                for (int j = 1;j <= n; j++){  // 도착지
                    if (k == i || k == j || i == j) continue;
                    if (price[i][k] + price[k][j] > price[i][j]) continue;
                    price[i][j] = price[i][k] + price[k][j];
                }
            }
        }
        for (int i = 1;i <= n; i++){
            for (int j= 1; j <= n; j++){
                if (price[i][j] == INF) sb.append("0").append(" ");
                else sb.append(price[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}