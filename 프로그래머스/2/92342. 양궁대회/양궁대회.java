class Solution {
    static int[] res = {-1};    // 정답 과녁
    static int[] lion;  // 라이언
    static int max = -1000; // 차이 값
    
    public static int[] solution(int n, int[] info) {
        lion = new int[11];     // 10 ~ 0까지
        DFS(info,1,n);
        return res;
    }
    public static void DFS(int[] info, int round, int n) {   // 점수 배열, 현재 라운드, 전체 라운드
        if(round == n + 1) {    // 끝나면
            int apeach_point = 0;
            int lion_point = 0;
            for(int i = 0; i <= 10; i++)    // 10 ~ 0까지 과녁
            {
                if(info[i] != 0 || lion[i] != 0) {  // 어피지 0 아니거나 라이언 0이 아니면
                    if(info[i] < lion[i])   // 라이언이 더 점수 큰 경우
                        lion_point += 10 - i;   // 더해줌
                    else
                        apeach_point += 10 - i; // 어피치 더해줌
                }
            }
            if(lion_point > apeach_point) {     // 라이언이 더 크면
                if(lion_point - apeach_point >= max)
                {
                    res = lion.clone();     // 복사
                    max = lion_point - apeach_point;    // 최대 차이 저장
                }
            }
            return ;
        }
        for(int j = 0; j <= 10 && lion[j] <= info[j]; j++) {    // 라이언의 움직임
            lion[j]++;
            DFS(info, round + 1, n);
            lion[j]--;
        }
    }
}