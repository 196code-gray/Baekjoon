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
        int[][] score = new int[N + 1][2]; // 숫자와 등수
        score[1][1] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            score[i][0] = Integer.parseInt(st.nextToken()); // 현재 점수, 등수
            if (score[i - 1][0] > score[i][0]) score[i][1] = i;
            else if (score[i - 1][0] == score[i][0]) score[i][1] = score[i - 1][1];
        }

        if (N == P && score[N][0] >= T) {
            System.out.println(-1);
            return;
        }

        int ans = 1;
        for (int i = 1; i <= N; i++) {
            if (score[i][0] > T)
                ans = i + 1;

            else break;
        }
        System.out.println(ans);
    }
}