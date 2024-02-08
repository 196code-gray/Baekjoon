import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        dfs(0, 1, "");
        System.out.println(sb);
    }
    static void dfs(int depth, int s, String str){
        if (depth == m){
            sb.append(str).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++){
            dfs(depth + 1, i, str + i + " ");
        }
    }
}