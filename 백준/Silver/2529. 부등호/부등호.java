import java.io.*;
import java.util.*;

public class Main {
    static String[] a;
    static boolean[] visited = new boolean[10];
    static int k;
    static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    static String[] ans = new String[2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        a = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) a[i] = st.nextToken();

        dfs(0, "");
        System.out.println(ans[0]);
        System.out.print(ans[1]);
    }
    static void dfs(int depth, String s){
        if (depth == k + 1){
            boolean isTure = true;
            for (int i = 1; i <= k; i++){
                // 현재 부등호가 왼쪽보다 오른쪽이 더 커야할 경우. 그렇지 않으면 멈춤
                if (a[i -1].equals("<") && s.charAt(i -1) >= s.charAt(i)) {
                    isTure = false;
                    break;
                }
                // 현재 부등호가 왼쪽이 오른쪽보다 더 커야할 경우. 그렇지 않으면 멈춤
                if (a[i -1].equals(">") && s.charAt(i -1) <= s.charAt(i)) {
                    isTure = false;
                    break;
                }
            }
            if (isTure) {
                if (max < Long.parseLong(s)) {
                    ans[0] = s;
                    max = Long.parseLong(s);
                }
                if (min > Long.parseLong(s)){
                    ans[1] = s;
                    min = Long.parseLong(s);
                };
            }
            return;
        }
        for (int i = 0; i <= 9; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(depth + 1, s + i);
                visited[i] = false;
            }
        }
    }
}