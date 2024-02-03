import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] friend = new int[n+1][n+1];
        for (int i = 1;i <= n; i++){
            String[] s = br.readLine().split("");
            for (int j = 1; j <= n; j++){
                char c = s[j -1].charAt(0);
                if (c == 'Y'){  // 친구일 경우 1 표시
                    friend[i][j] = 1;
                }
                else if (i != j){
                    friend[i][j] = 1000000;
                }
            }
        }
        // 플로이드 와샬
        for (int k = 1; k <= n; k++){   // 경유
            for (int i = 1; i <= n; i++){   // 출발
                for (int j = 1; j <= n; j++){   // 도착
                    if (k == i || k == j || j == i) continue;
                    else if (friend[i][j] > friend[i][k] + friend[k][j]){ // 최솟값일 경우
                        friend[i][j] = friend[i][k] + friend[k][j];
                    }
                }
            }
        }
        int ans = 0;
        // 2 - 친구 구하기
        for (int i = 1;i <= n; i++){
            int count = 0;
            for (int j = 1; j <= n; j++){
                if (i == j) continue;

                else if (friend[i][j] <= 2) {
                    count++;
                }
            }
            if (ans < count) ans = count;
        }
        System.out.println(ans);
    }
}