import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] node;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        node = new int[n + 1];
        list = new List[n + 1];
        for (int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        visited = new boolean[n + 1];
        bfs(1);

        for (int i = 2; i < node.length; i++) {
            System.out.println(node[i]);
        }
    }
    static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            List<Integer> now2 = list[now];
            for (Integer i : now2) {
                if (visited[i]) continue;
                q.add(i);
                node[i] = now;
            }
        }
    }
}