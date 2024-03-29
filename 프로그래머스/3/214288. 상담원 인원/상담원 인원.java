import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int consultantCount;
    int[][] requestList;

    public int solution(int k, int n, int[][] reqs) {
        consultantCount = k;
        requestList = reqs;
        combination(0, n - 1, k - 1, new boolean[n - 1]);
        return answer;
    }

    void combination(int start, int n, int r, boolean[] ary) {
        if (r == 0) {
            int[] consultantList = new int[consultantCount];
            Arrays.fill(consultantList, 1);

            int index = 0;
            for (int i = 0; i < ary.length; i++) {
                if (ary[i]) {
                    index++;
                    continue;
                }

                consultantList[index]++;
            }

            measureTime(consultantList);
        }

        for (int i = start; i < n; i++) {
            ary[i] = true;
            combination(i + 1, n, r - 1, ary);
            ary[i] = false;
        }
    }

    void measureTime(int[] consultantList) {
        int waitTime = 0;
        PriorityQueue<Integer>[] endQueueList = new PriorityQueue[consultantList.length];
        for (int i = 0; i < consultantList.length; i++) {
            endQueueList[i] = new PriorityQueue<>();
        }

        for (int[] request: requestList) {
            int start = request[0];
            int end = request[1];
            int type = request[2] - 1;

            if (endQueueList[type].size() < consultantList[type]) {
                endQueueList[type].offer(start + end);
                continue;
            }

            int next = endQueueList[type].poll();
            if (next > start) {
                waitTime += next - start;
                endQueueList[type].offer(next + end);
            }
            else {
                endQueueList[type].offer(start + end);
            }
        }

        answer = Math.min(answer, waitTime);
    }
}