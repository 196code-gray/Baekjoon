import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        N = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            N[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(N);
        dfs(0, "");
        System.out.println(sb);
    }
    static void dfs(int depth, String str){
        if (depth == m){
            sb.append(str).append("\n");
            return;
        }

        for (int i = 0; i < n; i++){
                dfs(depth + 1,  str + N[i] + " ");
        }
    }
}