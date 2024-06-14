import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 999_999_999;
    static int N, M, A, B, C, max, dist[];
    static BufferedReader br;
    static StringTokenizer st;
    static List<Node>[] list;
    static PriorityQueue<int[]> q;

    static class Node {
        int e, c;

        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = -1;
        dist = new int[11];

        list = new List[11];
        for (int i = 1; i <= 10; i++)
            list[i] = new ArrayList<>();

        q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, c));
        }

        Arrays.fill(dist, INF);

        q.offer(new int[]{A, 0, 0}); // 출발 노드, 총 금액, 골목 최고 금액
        while(!q.isEmpty()){
            int[] now = q.poll();
            int ns = now[0];
            int nm = now[1];

            for (Node i : list[ns]){
                int next = i.e;
                int money = i.c + nm;
                int min = i.c < now[2] ? now[2] : i.c;
                if (dist[next] > min && C >= money){
                    dist[next] = min;
                    q.offer(new int[]{next, money, min});
                }
            }
        }

        if (dist[B] != INF)
            max = dist[B];
        System.out.println(max);

    }
}