import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[9];
        visited = new boolean[9];
        Repeat(0);
    }
    static void Repeat(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[k] = i;
                visited[i] = true;
                Repeat(k + 1);
                visited[i] = false;
            }
        }
    }
}