import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Problem> q = new PriorityQueue<>();
        long[] hanb = new long[2];    // 한별 아이디어, 구현
        long ans = 0;    // 틀렸습니다 개수
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (t == 1) p =0;
            if (e == 1) {
                d = (d/2) + (d%2);
                p /=2;
            }
            q.offer(new Problem(d,p));
        }
        st = new StringTokenizer(br.readLine());
        hanb[0] = Integer.parseInt(st.nextToken()); hanb[1] = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> a = new PriorityQueue<>();
        while (m --> 0){
            while (!q.isEmpty() && q.peek().d <= hanb[0]) a.offer(q.poll().p);
            if (a.isEmpty()) {
                System.out.println(-1);
                return;
            }
//            Problem now = q.poll();

            int p = a.poll();
            if (p > hanb[1])  ans += p - hanb[1];
            hanb[0]++; hanb[1]++;

//            if (hanb[0] >= now.d){
//                if (hanb[1] >= now.p){
//                    hanb[0]++; hanb[1]++;
//                }
//                else {
//                    ans += now.p - hanb[1];
//                    hanb[0]++; hanb[1]++;
//                }
//            }
        }
//        if (m != 0 && q.isEmpty()) {
//            System.out.println(-1);
//            return;
//        }
        System.out.println(ans);
    }
    static public class Problem implements Comparable<Problem>{
        int d, p;

        public Problem(int d, int p) {
            this.d = d;
            this.p = p;
        }

        @Override
        public int compareTo(Problem o) {
            return d - o.d;
        }
    }
}
