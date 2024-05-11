import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static ArrayList<Node>[] list;
    static PriorityQueue<Integer>[] q;
    static public class Node{
        int e, time;

        public Node(int e, int time) {
            this.e = e;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        q = new PriorityQueue[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 0;i <= n; i++){
            list[i] = new ArrayList<>();
            q[i] = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, t));
        }

        dijkstra();

        for (int i = 1; i <= n; i++){
            if (q[i].size() != k) System.out.println(-1);
            else System.out.println(q[i].peek());
        }
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.offer(new int[]{1, 0});
        q[1].offer(0);

        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int s = now[0];
            int t = now[1];

            for (Node i : list[s]) {
                int next_s = i.e;
                int next_t = i.time + t;

                if (q[next_s].size() < k){
                    q[next_s].offer(next_t);
                    pq.offer(new int[]{next_s, next_t});
                } else if (q[next_s].peek() > next_t){
                    q[next_s].poll();
                    q[next_s].offer(next_t);
                    pq.offer(new int[]{next_s, next_t});
                }
            }
        }
    }
}