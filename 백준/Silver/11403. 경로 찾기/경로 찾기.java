import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] dist = new boolean[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0;j < n; j++){
                if (st.nextToken().equals("1")) dist[i][j] = true; // 1일 경우 연결 됨 표시
                else dist[i][j] = false;
            }
        }

        // 플로이드 워셜 알고리즘
        for (int k = 0; k <n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0;j < n; j++){

                    if (dist[k][j] && dist[i][k]) dist[i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < n; i++){
            for (int j = 0; j < n; j++){
                sb.append((dist[i][j]) ? "1" : "0").append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}