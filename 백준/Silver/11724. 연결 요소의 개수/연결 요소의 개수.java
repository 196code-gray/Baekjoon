import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] vist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[n + 1];
        vist = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!vist[i]) {
                count++;
                dfs(i);
            }
            
        }
        System.out.println(count);
    }
    static void dfs (int v) {
        if (vist[v]) return;
        
        vist[v] = true;
        for (int i : arr[v]) {
            if (vist[i] == false) {
                dfs(i);
            }
        }
    }
}