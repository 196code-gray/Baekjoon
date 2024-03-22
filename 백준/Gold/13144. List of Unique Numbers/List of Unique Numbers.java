import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1]; boolean[] use = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) num[i] = Integer.parseInt(st.nextToken());

        int s = 1, e = 1;
        long ans = 0;
            while (true){
                if (e == n+1){
                    ans += e - s;
                    s++;

                    if (s == n+1) break;
                }

                else if (!use[num[e]]){  // 중복 숫자 아닌 경우
                    use[num[e++]] = true;
                }
                else if (use[num[e]]){
                    ans += e -s;
                    use[num[s++]] = false;
                }
            }
        System.out.println(ans);
    }
}