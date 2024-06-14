import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int maxCost, totalCost, vertex;
        
        Node(int maxCost, int totalCost, int vertex) {
            this.maxCost = maxCost;
            this.totalCost = totalCost;
            this.vertex = vertex;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.totalCost, o.totalCost);
        }
    }

    static int n, m, start, end, c;
    static List<int[]>[] graph;
    static boolean[][] visited;
    static final int INF = (int) 1e9;
    static int result = INF;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        c = sc.nextInt();
        
        graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        visited = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
        }
        
        dijkstra(start);
        
        if (result != INF) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, start));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int maxCost = current.maxCost;
            int totalCost = current.totalCost;
            int now = current.vertex;
            
            if (totalCost > c) {
                continue;
            }
            
            for (int[] next : graph[now]) {
                int nextVertex = next[0];
                int cost = totalCost + next[1];
                
                if (cost > c || visited[now][nextVertex]) {
                    continue;
                } else if (nextVertex == end) {
                    result = Math.min(result, Math.max(maxCost, next[1]));
                }
                
                visited[now][nextVertex] = true;
                pq.add(new Node(Math.max(maxCost, next[1]), cost, nextVertex));
            }
        }
    }
}
