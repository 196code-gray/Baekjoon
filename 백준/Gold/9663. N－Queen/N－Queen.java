import java.io.*;
import java.util.*;

public class Main {
    static int n, ans;
    static int[] queen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ans = 0; queen = new int[n];
        dfs(0);
        System.out.println(ans);
    }
    static void dfs(int depth){
        if (depth == n){
            ans++;
            return;
        }

        for (int i = 0; i < n; i++){
            boolean now = true;
            queen[depth] = i;
            for (int j= 0; j < depth; j++){
                if (depth - j == Math.abs(queen[depth] - queen[j]) || queen[depth] == queen[j]){
                    now = false;
                    break;
                }
            }
            if (now){
                dfs(depth+1);
            }
        }
    }
}