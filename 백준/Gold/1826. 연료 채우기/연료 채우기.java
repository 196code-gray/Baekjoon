import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] station = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            station[i][0] = Integer.parseInt(st.nextToken());  // 현 위치로부터 떨어진 거리
            station[i][1] = Integer.parseInt(st.nextToken());  // 넣을 수 있는 연료 값
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int gas = Integer.parseInt(st.nextToken());

        Arrays.sort(station, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        int ans = 0;
        boolean out = false;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (gas < x) {
            while (i < n && gas >= station[i][0]) {
                pq.add(station[i][1]);
                i++;
            }

            if (pq.isEmpty()) {
                out = true;
                break;
            }

            gas += pq.poll();
            ans++;
        }

        System.out.println(out ? -1 : ans);
    }
}