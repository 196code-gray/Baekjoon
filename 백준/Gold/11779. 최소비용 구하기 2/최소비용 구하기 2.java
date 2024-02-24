    import java.io.*;
    import java.util.*;

    public class Main {
        static int n, m, min = Integer.MAX_VALUE;
        static long[] dist;
        static int[] dis;
        static ArrayList<ArrayList<Node>> list;
        static final int INF = 100_000_010;
        static boolean[] visit;
        static class Node implements Comparable<Node> {
            int e, cost;
            public Node(int e, int cost) {
                this.e = e;
                this.cost = cost;
            }
            @Override
            public int compareTo(Node o) {
                return cost - o.cost;
            }

        }
        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine()); m = Integer.parseInt(br.readLine()); // 노선, 버스
            dist = new long[n + 1];
            list = new ArrayList<>();
            ArrayList<Integer> cost = new ArrayList<>();
            for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
            StringTokenizer st;
            visit = new boolean[n +1]; // 방문여부
            dis = new int[n+1];
            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.get(s).add(new Node(e, c)); // 해당 출발점에서 도착점으로 가는 도시, 비용
            }
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 출발 노드
            int E = Integer.parseInt(st.nextToken()); // 도착 노드
            Arrays.fill(dist, INF);
            dijkstra(S,E);
            System.out.println(min);
            StringBuilder sb = new StringBuilder();

            int now = E;
            while (now != 0){
                cost.add(now);
                now = dis[now];
            }
            System.out.println(cost.size());
            for (int i = cost.size() -1; i >= 0; i--) {
                sb.append(cost.get(i)).append(" ");
            }
            System.out.println(sb);
        }
        static void dijkstra(int s, int end){
            dist[s] = 0;
            dis[s] = 0;
            PriorityQueue<Node> q = new PriorityQueue<>();
            q.offer(new Node(s, 0));
            while (!q.isEmpty()){
                Node no = q.poll();

                if (!visit[no.e]) visit[no.e] = true;
                else continue;

                for (Node i : list.get(no.e)) {
                    if (dist[i.e] > i.cost + dist[no.e]) {
                        dist[i.e] = i.cost + dist[no.e];
                        q.offer(new Node(i.e, (int) dist[i.e]));
                        dis[i.e] = no.e; // 전 노드 저장
                    }
                }
            }
            min = Math.min((int) dist[end], min);
        }
    }