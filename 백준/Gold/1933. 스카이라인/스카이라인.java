import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static class Building{
        int L, H;

        public Building(int l, int h) {
            L = l;
            H = h;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb =new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Building> q = new PriorityQueue<>(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                if (o1.L == o2.L){
                    return o2.H - o1.H;
                }
                else return o1.L - o2.L;
            }
        });

        for (int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            int L =Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            q.offer(new Building(L, H)); // 시작점
            q.offer(new Building(R, -H));  // 끝점
        }

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); // 건물 높이 내림차순
        map.put(0, 1);
        int maxX = 0; int maxH = 0;

        while(!q.isEmpty()){
            Building now = q.poll();

            if (now.H > 0) { // 시작점일 경우(양수)
                map.put(now.H, map.getOrDefault(now.H, 0) + 1);
            } else { // 끝점일 경우(음수)
                int h = map.get(-now.H); 
                if (h == 1){
                    map.remove(-now.H);
                } else {
                    map.replace(-now.H, h -1); 
                }
            }

            int h = map.firstKey();
            if (maxX != now.L && maxH != h){
                sb.append(now.L).append(" ").append(h).append(" ");
                maxX = now.L;
                maxH = h;
            }
        }
        System.out.println(sb);
    }
}