import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1, 0);
    }
    static void dfs(int now, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = now;i<=n;i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}