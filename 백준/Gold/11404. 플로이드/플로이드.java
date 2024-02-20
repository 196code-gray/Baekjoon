import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); int m = Integer.parseInt(br.readLine());
        int[][] price = new int[n][n];
        for (int i = 0; i < n; i++){ // 각 위치 최댓값으로 지정
            Arrays.fill(price[i], 100_000_000);
            price[i][i] = 0; // 본인 위치 0
        }
        for (int k = 0; k < m; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) -1; int e = Integer.parseInt(st.nextToken()) -1;
            int p = Integer.parseInt(st.nextToken());
            price[s][e] = Math.min(p, price[s][e]);
        }
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (price[i][j] > price[i][k] + price[k][j]){
                        price[i][j] = price[i][k] + price[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i= 0; i < n; i++){
            for (int j = 0;j < n; j++){
                if (price[i][j] == 100_000_000) sb.append(0).append(" ");
                else sb.append(price[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}