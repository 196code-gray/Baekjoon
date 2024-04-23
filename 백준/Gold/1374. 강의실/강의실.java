import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 회의실 개수

        Meeting[] m = new Meeting[t];
        for (int i = 0; i < t; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            st.nextToken();
            m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(m);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(m[0].e);

        int ans = 0;

        for (int i = 1; i < t; i++){
            if (q.peek() <= m[i].s) {  // 현재 회의 끝나는 시간과 같거나 뒤인 경우
                q.poll();
                q.offer(m[i].e);
            }
            else q.offer(m[i].e);  // 현재 회의 끝나는 시간보다 전에 시작할 경우
            ans = Math.max(ans, q.size());
        }

        System.out.println(q.size());
    }
    static class Meeting implements Comparable<Meeting> {
        int s,e;

        public Meeting(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Meeting o){
            if (s == o.s) return e - o.e;
             else return s - o.s;
        }
    }
}