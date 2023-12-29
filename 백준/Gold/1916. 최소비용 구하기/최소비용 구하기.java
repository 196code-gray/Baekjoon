import java.io.*;
import java.util.*;

public class Main {
    static List<Edge>[] list;
    static long[] price;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); int m = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        price = new long[n + 1];
        Arrays.fill(price, Long.MAX_VALUE);
        for (int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, price));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken());
        price[s] = 0;
        dijkstra(s);

        System.out.println(price[e]);

    }
    static void dijkstra(int start){
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(start, 0));
        while(!q.isEmpty()){
            Edge now = q.poll();
            if (price[now.node] < now.price) continue;
            for (Edge next : list[now.node]){
                int e = next.node;
                long p = next.price;

                if (price[e] > price[now.node] + p){
                    price[e] = now.price + p;
                    q.offer(new Edge(e, price[e]));
                }
            }
        }

    }
    static class Edge implements Comparable<Edge>{
        int node;
        long price;

        public Edge(int node, long price) {
            this.node = node;
            this.price = price;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(price, o.price);
        }
    }
}