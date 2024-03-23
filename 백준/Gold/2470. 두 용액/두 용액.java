import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);

        int ans = Integer.MAX_VALUE;
        int s,e; s = 0; e = n -1;
        int[] result = new int[2];

        while (s < e){
            int now = num[s] + num[e];

            if (ans > Math.abs(now)) {
                ans = Math.abs(now);
                result[0] = num[s]; result[1] = num[e];

                if (now == 0) break;
            }

            if (now > 0){
                e--;
            }
            else
                s++;
        }
        System.out.println(result[0] + " " + result[1]);
    }
}