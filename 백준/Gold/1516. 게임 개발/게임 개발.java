import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 건물의 개수
        List<Integer>[] first = new List[n + 1];  // 먼저 지어야하는 건물과 기다리는 건물 저장
        int[] entry = new int[n + 1];     // 수마다 먼저 지어야하는 건물 개수
        int[] time = new int[n + 1];     // 건물을 짓는 시간
        int[] ans = new int[n + 1]; // 총 건물 시간
        for (int i = 1; i <= n; i++) first[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break;   // -1이 나올때까지 반복
                entry[i]++;
                first[num].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (entry[i] == 0) {
                q.offer(i);
                ans[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < first[now].size(); i++) {
                int next = first[now].get(i);

                ans[next] = Math.max(ans[next], ans[now] + time[next]);     // 먼저 지어야하는 건물들 중 제일 시간이 오래 걸리는 건물을 찾는다
                entry[next]--;  // 하나의 먼저 지어진 건물을 다 지었으므로 개수에서 제외
                if (entry[next] == 0) q.offer(next);    // 만약 먼저 지어야하는 건물이 다 지어진 상태라면 q에 넣어줌
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(ans[i]).append("\n");
        System.out.println(sb);
    }
}