import java.io.*;
import java.util.*;

public class Main {

    static int n; 
    static int m;
    static int[][] cost; 

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cost = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int middle = 1; middle < n+1; middle++){
            for(int start = 1; start < n+1; start++){
                for(int end = 1; end < n+1; end++){
                    cost[start][end] = Math.min(cost[start][end], cost[start][middle]+cost[middle][end]);
                }
            }
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long time = Long.parseLong(st.nextToken());
            if(cost[start][end] <= time) {
                sb.append("Enjoy other party").append("\n");
            } else {
              sb.append("Stay here").append("\n");
            }
        }
        System.out.println(sb);
    }
}