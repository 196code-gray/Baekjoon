import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[][] friend = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(friend[i], 100_000);
            friend[i][i] = 0;
        }
        for (int i = 1; i<= m; i++){
            st =new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            friend[s][e] = 1; // 친구관계 기록
            friend[e][s] = 1;
        }
        for (int cost = 1; cost <= n; cost++){
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n;j++){
                    if (cost == i || cost == j || i == j) continue;

                    if (friend[i][cost] + friend[cost][j] < friend[i][j]){ // 현재 값보다 최저라면
                        friend[i][j] = friend[i][cost] + friend[cost][j];
                    }
                }
            }
        }
        int min = 100_000; int ans = 0;
        for (int i = 1; i <= n; i++){
            int sum = 0;
            for (int j = 1;j<= n;j++){
                sum += friend[i][j];
            }
            if (min > sum){
                min = sum;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}