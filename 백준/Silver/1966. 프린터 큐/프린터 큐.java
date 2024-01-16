import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t --> 0){
            Queue<int[]> q = new LinkedList<>();    // 순서 그대로
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순
            int count = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++){
                int num = Integer.parseInt(st.nextToken());
                q.offer(new int[]{num, i});
                pq.offer(num);
            }
            while (!q.isEmpty()) {
                int[] now = q.poll();
                if (pq.peek() == now[0]){ // 현재 값이 최대값일 경우
                    if (now[1] == m){   // 현재 위치가 찾는 위치일 경우
                        sb.append(count).append("\n");
                        break;
                    }
                    count++;
                    pq.poll();
                } else {
                    q.offer(new int[]{now[0],now[1]});
                }
            }
        }
            System.out.print(sb);
    }
}