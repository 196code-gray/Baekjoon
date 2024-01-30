import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[20];
    static int n, ans;
    static int[][] lv;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lv = new int[n][n];
        for (int i = 0;i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j< n; j++){
                lv[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(ans);
    }
    static void dfs(int depth, int idx){
        if (depth == n / 2){
            team();
            return;
        }
        for (int i = idx; i < n; i++){
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    static void team(){
        int min, me; min = me = 0;
        for (int i = 0; i < n;i++){
            for (int j= 0; j < n; j++){
                if (i == j) continue;
                if (visited[i]){
                    if (visited[j]) me += lv[i][j];
                }
                else if (!visited[i]){
                    if (!visited[j]) min += lv[i][j];
                }
            }
        }
        if (Math.abs(me - min) < ans) ans = Math.abs(me -min);
    }
}