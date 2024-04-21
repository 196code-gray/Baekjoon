import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        // 현재 점수가 없는 경우
        if (N == 0) {
            System.out.println(1);
            return;
        }
        int[] score = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) score[i] = Integer.parseInt(st.nextToken()); // 현재 점수

        if (N == P && score[N] >= T) {
            System.out.println(-1);
            return;
        }

        int ans = 1;
        for (int i = 1; i <= N; i++){
            if (T <= score[i]){
                if (score[i] > T) ans++;
                else if (score[i] == T) ans = ans;
            }
            else break;
        }
        System.out.println(ans);
    }
}