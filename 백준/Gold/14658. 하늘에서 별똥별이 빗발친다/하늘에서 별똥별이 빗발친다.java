import java.io.*;
import java.util.*;

public class Main {
    static int n, m, l, k; // 행, 열, 트램펄린, 별
    static List<int[]> stars;  // 별 위치 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        stars = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        int res = Integer.MIN_VALUE;

        for (int[] s1 : stars) { // 트램펄린 놓을 행
            for (int[] s2 : stars) {  // 트램펄린 놓을 열
                res = Math.max(res, boundStar(s1[0], s2[1]));
            }
        }
        System.out.println(k - res);
    }
    private static int boundStar(int i, int j) {
        int res = 0;
        for (int[] s : stars) { // 모든 별 확인하면서 트램펄린으로 튕길 수 있는지 확인
            if (i <= s[0] && s[0] <= i + l && j <= s[1] && s[1] <= j + l) res++;
        }
        return res;
    }
}