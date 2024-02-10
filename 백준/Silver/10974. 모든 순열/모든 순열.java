import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n +1];
        dfs(0,  "");
        System.out.println(sb);
    }
    static void dfs(int depth, String str){
        if (depth == n){
            sb.append(str).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++){
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, str + i + " ");
                visited[i] = false;
            }
        }
    }
}