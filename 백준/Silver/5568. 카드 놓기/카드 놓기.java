import java.io.*;
import java.util.*;

public class Main {
    static int[] card;
    static int n, k, ans;
    static boolean[] vi;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new int[n];
        for (int i = 0; i < n; i++) card[i] = Integer.parseInt(br.readLine());
        vi = new boolean[n];

        dfs(0, "");

        System.out.println(ans);
    }
    static void dfs(int depth, String num){
        if (depth == k){
            int f = Integer.parseInt(num);
            if (!set.contains(f)){
                ans++;
                set.add(f);
            }
            return;
        }
        for (int i = 0; i < n; i++){
            if (!vi[i]) {
                vi[i] = true;
                dfs(depth + 1, num + card[i]);
                vi[i]  = false;
            }
        }
    }
}