import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int count = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parse = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list[parse].add(child);
            list[child].add(parse);
        }
        DFS(0, x, y);
        System.out.println(count);
    }

    static void DFS(int depth, int start, int end) {
        if (start == end) {
            count = depth;
            return;
        }
        visited[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);
            if (!visited[next]) {
                DFS(depth + 1, next, end);
            }
        }
    }
}