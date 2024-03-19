import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
        int[] front = new int[n];

        for (int i = 0; i < n; i++){
            front[i]= Integer.parseInt(br.readLine());
        }

        int[] use = new int[d + 1]; // 현재 연속으로 먹은 초밥 가지 수
        int notSame, ans, s; notSame= ans= s  = 0; // 가지 수 다른개 몇개인지, 정답
        int e = k -1;

        for (int i = s; i < k; i++){
            if (use[front[i]] == 0) { // 현재 초밥 종류가 없는 경우
                notSame++;
            }
            use[front[i]]++;
        }

        ans = notSame;

        while (true){
            if (ans <= notSame) {
                if (use[c] == 0){ // 아직 쿠폰 초밥을 안먹은 경우
                    ans = Math.max(notSame +1, ans);
                }
                else ans = notSame;
            }

            if (use[front[s]] == 1) { // 중복되는 초밥이 아닌 경우
                notSame--;  // 제거
            }
            use[front[s++]]--; // 초밥 제거

            e++;
            if (e >= n) e = 0; // 끝이 끝에 다다르면 처음과 비교

            if (use[front[e]] < 1) notSame++; // 증가한 초밥이 가지수가 다른 경우
            use[front[e]]++; // 그릇 추가

            ans = Math.max(ans, notSame);
            if (e == k -1) break;
        }
        System.out.println(ans);
    }
}