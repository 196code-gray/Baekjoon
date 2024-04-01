import java.util.*;

class Solution {
    // 최소 대기 시간을 저장할 변수
    int answer = Integer.MAX_VALUE;
    // 상담사 수
    int consultantCount;
    // 요청 목록
    int[][] requestList;

    // 주어진 요구 사항에 대해 최소 대기 시간을 구하는 메서드
    public int solution(int k, int n, int[][] reqs) {
        consultantCount = k; // 상담사 수 할당
        requestList = reqs; // 요청 목록 할당
        combination(0, n - 1, k - 1, new boolean[n - 1]); // 조합을 이용하여 상담사들에게 일을 배정
        return answer; // 최소 대기 시간 반환
    }

    // 조합을 구하는 메서드
    void combination(int start, int n, int r, boolean[] ary) {
        if (r == 0) { // 기저 조건: r이 0이 되면 조합 완성
            int[] consultantList = new int[consultantCount]; // 상담사 리스트 생성
            Arrays.fill(consultantList, 1); // 각 상담사의 일한 횟수 초기화

            int index = 0;
            for (int i = 0; i < ary.length; i++) {
                if (ary[i]) { // 해당 상담사가 일을 할 경우
                    index++; // 다음 상담사로 이동
                    continue;
                }

                consultantList[index]++; // 해당 상담사의 일한 횟수 증가
            }

            measureTime(consultantList); // 일한 시간을 측정하여 최소 대기 시간 갱신
        }

        for (int i = start; i < n; i++) {
            ary[i] = true; // 현재 상담사가 일을 하도록 설정
            combination(i + 1, n, r - 1, ary); // 재귀 호출로 다음 상담사의 일을 배정
            ary[i] = false; // 현재 상담사가 일을 마치고 다음 상담사로 넘어감
        }
    }

    // 일한 시간을 측정하여 최소 대기 시간을 갱신하는 메서드
    void measureTime(int[] consultantList) {
        int waitTime = 0; // 대기 시간 초기화
        PriorityQueue<Integer>[] endQueueList = new PriorityQueue[consultantList.length]; // 각 상담사가 일을 마치는 시간을 저장하는 우선순위 큐 배열 생성
        for (int i = 0; i < consultantList.length; i++) {
            endQueueList[i] = new PriorityQueue<>(); // 각 상담사에 대한 우선순위 큐 초기화
        }

        for (int[] request: requestList) { // 각 요청에 대해 반복
            int start = request[0]; // 요청 시작 시간
            int end = request[1]; // 요청 종료 시간
            int type = request[2] - 1; // 요청 타입

            if (endQueueList[type].size() < consultantList[type]) { // 해당 타입의 상담사가 일을 처리할 수 있는 경우
                endQueueList[type].offer(start + end); // 해당 상담사에게 일을 할당하고 종료 시간을 우선순위 큐에 추가
                continue;
            }

            int next = endQueueList[type].poll(); // 가장 일찍 끝나는 상담의 종료 시간
            if (next > start) { // 요청 시작 시간보다 먼저 끝난 경우
                waitTime += next - start; // 대기 시간 추가
                endQueueList[type].offer(next + end); // 해당 상담사에게 일을 할당하고 종료 시간을 우선순위 큐에 추가
            }
            else { // 요청 시작 시간에 일이 가능한 경우
                endQueueList[type].offer(start + end); // 해당 상담사에게 일을 할당하고 종료 시간을 우선순위 큐에 추가
            }
        }

        answer = Math.min(answer, waitTime); // 최소 대기 시간 갱신
    }
}