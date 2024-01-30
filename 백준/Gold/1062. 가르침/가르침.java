import java.io.*;
import java.util.*;

public class Main {
    static int n, k, ans;
    static boolean[] visited;
    static String[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        if (k == 26) {
            System.out.println(n);
            return;
        }
        if (k < 5) {
            System.out.println(0);
            return;
        }
        visited = new boolean[27];
        str = new String[n];
        for (int i = 0; i < n; i++){
            String now = br.readLine();
            now = now.replace("anta", "");
            now = now.replace("tica", "");
            str[i] = now;

        }
        ans = 0;
        visited[0] = true;
        visited[2] = true;
        visited[8] = true;
        visited[19] = true;
        visited[13] = true;
        dfs(0, 0);
        System.out.println(ans);
    }
    static void dfs(int depth, int idx){
        if (depth == k - 5){
            check();
            return;
        }
        for (int i = idx; i < 26; i++){
            // 현재 알파벳이 사용되지 않았을 경우
            if (!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
    static void check() {
        int count = 0;
        for (int i = 0; i < n; i++){
            boolean isTrue = true;
            for (int j = 0; j < str[i].length(); j++){
                if (!visited[str[i].charAt(j) - 'a']) isTrue = false;
            }
            if (isTrue) count++;
        }

        if (ans < count) ans = count;
    }
}