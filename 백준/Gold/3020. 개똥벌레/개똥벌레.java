import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int h = Integer.parseInt(st.nextToken());
        int[] s = new int[h + 1]; int[] j = new int[h + 1]; // 석순, 종유석
        for (int i = 1; i <= n /2; i++){
            int down = Integer.parseInt(br.readLine()); // 석순
            int up = Integer.parseInt(br.readLine());   // 종유석
            s[down]++;  // 해당 높이에 장애물이 있다는 표시
            j[up]++;
        }
        for (int i = h -1; i > 0; i--){
            s[i] += s[i + 1];
            j[i] += j[i + 1];
        }
        int ans = n; int idx = h; int count = 0;
        // 현재 구간에서의 부술 장애물 개수 계산
        for (int i = 1; i <= h; i++){
            // s에서 1 = j에서 7
            int breakB = s[i] + j[idx--];

            if (ans > breakB){
                ans = breakB;
                count = 1;
            }
            else if (ans == breakB) count++;
        }
        System.out.println(ans + " " + count);
    }
}