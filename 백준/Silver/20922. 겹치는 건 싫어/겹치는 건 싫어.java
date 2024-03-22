import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());int k = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1], use = new int[100_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) num[i] = Integer.parseInt(st.nextToken());

        int s = 1, e = 1;
        long ans = 0;
            while (true){
                if (e == n+1){
                    ans = Math.max(e - s, ans);
                    s++;

                    if (s == n+1) break;
                }

                else if (use[num[e]] + 1 > k){  // 안되는 경우
                    ans = Math.max(ans, e - s);
                    use[num[s++]]--;
                }
                else if (use[num[e]] + 1 <= k){ // 되는 경우
                    use[num[e++]]++;
                }
            }
        System.out.println(ans);
    }
}