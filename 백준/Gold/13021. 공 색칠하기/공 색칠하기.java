import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] recentColor = new int[n + 10];
       // Arrays.fill(recentColor, 0); // 자바에서는 배열을 선언할 때 기본값으로 초기화되기는 하지만, 명확성을 위해 0으로 초기화합니다.

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            for (int j = l; j <= r; j++) {
                recentColor[j] = i; // 각 구간에 대한 최근 색상 번호를 저장합니다.
            }
        }

        boolean[] appeared = new boolean[n + 10];
        int distincts = 0; // 다양한 색상의 수를 계산합니다.

        for (int i = 1; i <= n; i++) {
            if (recentColor[i] > 0 && !appeared[recentColor[i]]) {
                appeared[recentColor[i]] = true;
                distincts++; // 새로운 색상이 나타나면 다양한 색상의 수를 증가시킵니다.
            }
        }

        System.out.println(1L << distincts); // 최종적으로 나올 수 있는 조합의 수를 출력합니다.

        
    }
}
