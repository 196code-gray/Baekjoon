import java.util.*;
import java.io.*;

public class Main {
    static int[] flow;
    static boolean[] open = new boolean[21];
    static int n,m,ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        open[Integer.parseInt(st.nextToken()) -1] = true; open[Integer.parseInt(st.nextToken()) -1] = true;
        m = Integer.parseInt(br.readLine());
        flow = new int[m];
        for (int i = 0; i < m; i++){
            flow[i] = Integer.parseInt(br.readLine())-1;
        }

        dfs(0,0);
        System.out.println(ans);
    }
    static void dfs(int count, int now){
        if (now == m){
            ans = Math.min(ans, count);
            return;
        }
        int move = flow[now];
        if (open[move]) dfs(count, now + 1);
        else {
            int idx = -1;
            for (int i = move; i < n; i++){
                if (open[i]){
                    idx = i;
                    break;
                }
            }
            if (idx != -1){
                open[move] = true;
                open[idx] = false;
                dfs(idx - move + count , now + 1);
                open[move] = false;
                open[idx] = true;
            }
            idx = -1;
            for (int i =  move; i >= 0; i--){
                if (open[i]){
                    idx = i;
                    break;
                }
            }
            if (idx != -1){
                open[move] = true;
                open[idx] = false;
                dfs(move - idx + count, now + 1);
                open[move] = false;
                open[idx] = true;
            }
        }
    }
}