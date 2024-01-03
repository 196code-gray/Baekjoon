import java.io.*;
import java.util.*;

public class Main {
    static int v, e, k;
    static List<Edge>[] arr;
    static long[] distance;
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
    public static void main(String[] args) throws Exception {
        v = read(); e = read(); k = read() -1;
        arr = new List[20001];
        for (int i = 0; i < v; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++){
            int s = read() -1;
            int e = read() -1;
            int p = read();
            arr[s].add(new Edge(e, p));
        }
        distance = new long[20001];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[k] = 0;
        dijkstr(k);

        for (int i = 0; i < v; i++) {
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