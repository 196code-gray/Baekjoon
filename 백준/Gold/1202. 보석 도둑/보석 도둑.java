import java.io.*;
import java.util.*;

public class Main {
    static class Jewelry implements Comparable<Jewelry> {
        int m, v;

        public Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry o) {
            return Integer.compare(this.m, o.m); // 무게 오름차순
        }
    }

    static PriorityQueue<Jewelry> q;
    static int n, k;
    static int[] bags;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());

        q = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            q.offer(new Jewelry(m, v));
        }

        bags = new int[k];
        for (int i = 0; i < k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags); // 가방 무게도 오름차순(가벼운 가방부터)

        long ans = 0; // n = 300,000 * v = 1,000,000 => int 범위 초과
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 보석의 가치 내림차순(가방에 담을 수 있으면서 가장 가치가 높은 것)
        // 가방에 담을 수 있는 보석 순회
        for (int i = 0; i < k; i++){
            while(!q.isEmpty() && q.peek().m <= bags[i]) {
                pq.offer(q.poll().v); // 가치를 담음.
            }

            if (!pq.isEmpty()){
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
}