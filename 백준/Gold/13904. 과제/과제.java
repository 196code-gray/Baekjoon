import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static PriorityQueue<Assignment> q;
    static int[] day = new int[1001];
    static int n, ans;
    private static class Assignment implements Comparable<Assignment> {
        int d,s;

        public Assignment(int d, int s){
            this.d = d;
            this.s = s;
        }

        @Override
        public int compareTo(Assignment o){
            return o.s - this.s;
        }
    }
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = 0;

        q = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            q.offer(new Assignment(d, s));
        }

        while (!q.isEmpty()){
            Assignment now =  q.poll();
            int d = now.d;

            for (int i = d; i > 0; i--){
                if (day[i] != 0) continue;
                day[i] = now.s;
                break;
            }
        }

        for (int i : day){
            ans += i;
        }
        System.out.println(ans);
    }
}