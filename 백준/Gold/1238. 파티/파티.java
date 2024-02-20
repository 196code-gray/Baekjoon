import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node arg0) {
        return weight - arg0.weight;
    }
}

public class Main {
    static final int INF = 1_000_000;
    static ArrayList<ArrayList<Node>> go, back;
    static int n, x;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        go = new ArrayList<>(); // 문제의 입력을 그대로 받은 배열
        back = new ArrayList<>(); // 문제의 입력을 반대로 받은 배열

        for (int i = 0; i <= n; i++) {
            go.add(new ArrayList<>());
            back.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            go.get(start).add(new Node(end, weight));
            back.get(end).add(new Node(start, weight));
        }

        int[] dist1 = dijkstra(go); // X에서 시작점들 사이의 최단거리
        int[] dist2 = dijkstra(back); // 시작점들에서 X 사이의 최단거리

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        bw.write(ans + "\n");
        bw.flush();
    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));

        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : list.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist;
    }
}