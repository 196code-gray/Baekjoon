import java.util.*;

class Solution {
     public int solution(int k, int n, int[][] reqs) {
        int ans = 0;
        int[][] time = new int[21][k + 1]; int[] mento = new int[k + 1]; // 맨토 수에 따른 시간 저장, 현재 유형에 맨토
        int[] mm = new int[k + 1];
        int nn = n;
        n-=k; int count = 1;
        Arrays.fill(mento, 1);
        Arrays.fill(mm, 1);

        while (n != -1) {
            for (int i = 1; i <= k; i++) { // 현재 상담 유형
                PriorityQueue<Integer> q = new PriorityQueue<>(); // 가장 짧은 상담 시간이 먼저 오도록
                for (int j = 0; j < reqs.length; j++) {  // 각 유형에 맞는 상담 시간
                    if (reqs[j][2] != i) continue; // 현재 상담 유형과 다르다면 continue
                    if (mm[reqs[j][2]] > q.size()) {  // 상담 바로 가능한 멘토가 있을 경우
                        q.offer(reqs[j][1] + reqs[j][0]);
                    } else {
                        if (reqs[j][0] >= q.peek()) {  // 앞에 끝난 사람과 시간이 맞을 경우
                            q.poll();
                            q.offer(reqs[j][0] + reqs[j][1]);
                        } else {
                            int end = q.poll();
                            time[mm[reqs[j][2]]][reqs[j][2]] += end - reqs[j][0];
                            q.offer(end + reqs[j][1]);
                        }
                    }
                }
            }
            int idx = 0;
            if (n != nn - k) {
                int max = 0;
                for (int i = 1; i <= k; i++) {
                    if (max < Math.abs(time[mm[i] - 1][i] - time[mm[i]][i])) {
                        max = Math.max(Math.abs(time[mm[i] - 1][i] - time[mm[i]][i]), max); // 현재 인덱스 시간보다 i 시간이 더 크다면 변경
                        idx = i;
                    }
                }
                if(idx == 0) break;
            }
            for (int i = 1; i<= k; i++) mm[i]++;
            if (n != nn - k) {
                mento[idx]++; // n이 0이 아닐경우 해당 유형 멘토 증가

                for (int i = 1; i <= k; i++) {
                    if (i == idx) continue;
                    mm[i]--;
                }
            }
            nn++;
            if (n != nn - k) n--;
        }
        for (int i = 1; i <= k; i++) ans += time[mento[i]][i];
//        System.out.println(ans);
        return ans;
    }
}