import java.io.*;
import java.util.*;

public class Main {
    static int[][] question;
    static int ans, n;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=  Integer.parseInt(br.readLine());
        question = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            question[i][0] = Integer.parseInt(st.nextToken());
            question[i][1] = Integer.parseInt(st.nextToken());
            question[i][2] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[10];
        ans = 0;
        dfs(0,  "");
        System.out.println(ans);
    }
    static void dfs(int depth, String s){
        if (depth == 3){
            check(s);
            return;
        }

        for (int i = 1; i <= 9; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(depth + 1,  s+i);
                visited[i] = false;
            }
        }
    }
    static void check(String s){
        for (int i = 0; i < n; i++){
            String now = String.valueOf(question[i][0]);
            int st, b;
            st = b =0;

            for (int j =0; j < 3; j++){
                if (s.charAt(j) == now.charAt(j)) st++;
            }
            if (question[i][1] != st) return;

            for (int j = 0; j < 3; j++){
                int last = (j + 1) % 3;
                if (s.charAt(j) == now.charAt(last)) b++;
                last = (j + 2) % 3;
                if (s.charAt(j) == now.charAt(last)) b++;
            }
            if (question[i][2] != b) return;
        }
        ans++;
    }
}