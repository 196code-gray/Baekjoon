import java.util.*;
class Solution {
    static String[] dd;
    static boolean[] visited;
    static int ans;
    static String[] p = {"A", "C","F", "J", "M", "N", "R", "T"};
    public int solution(int n, String[] data) {
        dd = data;
        ans = 0;
        visited = new boolean[8];
        dfs(0, "");
        return ans;
    }
    static void dfs(int depth, String s){
        if (depth == 8){
            if(check(s)){
                ans++;
            }
            return;
        }
        for (int i = 0; i < 8; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(depth + 1, s + p[i]);
                visited[i] = false;
            }
        }
    }

    private static boolean check(String s) {
        for (String data : dd) {
            int idx = (Math.abs(s.indexOf(data.charAt(0)) - s.indexOf(data.charAt(2))) -1);
            char b = data.charAt(3);
            int dis = data.charAt(4)-'0';

            if (b == '=') {
                if (idx != dis) return false;
            }
            else if (b == '>') {
                if (dis >= idx) return false;
            }
            else {
                if (dis <= idx) return false;
            }
        }
        return true;
    }
}