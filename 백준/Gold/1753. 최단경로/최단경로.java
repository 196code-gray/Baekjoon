import java.io.*;
import java.util.*;

public class Main {
    static int v, e, k;
    static List<Edge>[] arr;
    static long[] distance;
//    static boolean[] visited = new boolean[100_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v= Integer.parseInt(st.nextToken()); e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        arr = new List[20001];
        for (int i = 1; i <= v; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[s].add(new Edge(e, p));
        }
        distance = new long[20001];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[k] = 0;
        dijkstr(k);

        for (int i = 1; i <= v; i++) {
            if (distance[i] == Long.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
    static class Edge implements Comparable<Edge> {
        long node;
        long plus;

        public Edge(long now, long time) {
            this.node = now;
            this.plus = time;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(plus, o.plus);
        }
    }
    private static void dijkstr(int k) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(k, 0));
//        visited[k] = true;
        while (!q.isEmpty()){
            Edge now = q.poll();
            if (distance[(int) now.node] < now.plus) continue;
            for (Edge next : arr[(int) now.node]) {
                int n = (int) next.node;
                long p = next.plus;
                if (distance[n] > now.plus + p){
                    distance[n] = now.plus + p;
                    q.offer(new Edge(n, distance[n]));
//                    visited[n] = true;
                }
            }
        }
    }
}
