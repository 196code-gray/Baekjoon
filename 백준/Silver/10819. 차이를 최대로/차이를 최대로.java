import java.util.*;
import java.io.*;

public class Main {
    static int[] max, num;
    static boolean[] visited;
    static int n, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = new int[n]; num = new int[n]; ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        dfs(0);
        System.out.println(ans);
    }
    static void dfs(int depth){
        if (depth == n){
            int now = 0;
            for (int i = 1; i < n; i++){
                now += Math.abs(max[i -1] - max[i]);
            }
            if (now > ans) ans = now;
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                max[depth] = num[i];
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}