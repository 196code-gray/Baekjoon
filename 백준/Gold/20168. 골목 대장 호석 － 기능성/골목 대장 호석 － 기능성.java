import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;

public class Main {
    static int N, C;
    static long[] dist;
    static List<List<Node>> graph = new ArrayList<>();
    static long answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int A = parseInt(st.nextToken());
        int B = parseInt(st.nextToken());
        C = parseInt(st.nextToken());

        dist = new long[N + 1];
        graph.add(null);
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        int u, v;
        long w;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = parseInt(st.nextToken());
            v = parseInt(st.nextToken());
            w = Long.parseLong(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        binSearch(A, B);
        System.out.println(answer);
        br.close();
    }

    static void binSearch(int start, int end) {
        long low = 1;
        long high = 1001;
        long mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (dijkstra(start, end, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    static boolean dijkstra(int start, int end, long x) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.w));
        Arrays.fill(dist, MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.v] < cur.w) continue;

            for (Node next : graph.get(cur.v)) {
                if (next.w > x) continue;

                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[end] <= C;
    }

    static class Node {
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }
}