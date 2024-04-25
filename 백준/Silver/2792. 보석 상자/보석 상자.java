import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());

        int[] jewel = new int[m];
        int low = 1; int high = 0;

        for (int i = 0; i < m; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, jewel[i]);
        }
        long ans = 0;

        while(low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;
            for (int i = 0; i < m; i++) {
                sum += jewel[i] / mid;
                if (jewel[i] % mid != 0) sum++;
            }
            if (sum <= n) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        System.out.println(ans);
    }
}