import java.io.*;
import java.util.*;

public class Main {
    static int n, k, max;
    static int[] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        num = new int[k]; max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i= 0; i < k; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int now){
        if (n < now) return;

        if (max < now) max = now;

        for (int i = k -1; i >= 0; i--){
            dfs(now * 10 + num[i]);
        }
    }
}