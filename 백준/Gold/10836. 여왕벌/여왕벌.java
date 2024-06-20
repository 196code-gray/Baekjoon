import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] s) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[m * 2 - 1];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
           
            int i = Integer.parseInt(st.nextToken());
            
            //1과2가 증가 되는 부분을 입력받은 카운트만큼 각각 증가
            for (int j = 1; j <= 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                while (num-- > 0) arr[i++] += j;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            sb.append(arr[i] + 1).append(" ");
            //0번째를 제외한 첫번째 행을 출력
            for (int j = m; j < 2 * m - 1; j++) {
                sb.append(arr[j] + 1).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}