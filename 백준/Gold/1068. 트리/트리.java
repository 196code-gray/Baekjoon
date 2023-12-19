import java.io.*;
import java.util.*;

public class Main {
    static int n, delete, root;
    static int[] arr;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == -1) root = i;
        }
        delete = Integer.parseInt(br.readLine());
        deleteNode(delete);

        dfs(root);

        System.out.println(count);
    }
    static void deleteNode(int del) {
            arr[del] = -2;
            for (int i = 0;i<n;i++) {
                if (arr[i] == del) {
                deleteNode(i);
            }
        }
    }
    static void dfs(int node) {
        boolean leaf = true;
        visited[node] = true;
        if (arr[node] != -2) {
            for (int i = 0;i<n;i++){
                if (!visited[i] && arr[i] == node) {
                    dfs(i);
                    leaf = false;
                }
            }
            if (leaf)  count++;
        }
    }
}