class Solution {
    static boolean[] visited;   // 방문 배열
    static int count;   // 던전 수
    public int solution(int k, int[][] dungeons) {
        // 던전 길이와 방문 배열 길이 일치하게 선언
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }
    private void dfs(int depth, int hp, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            // 만약 방문을 했거나 현재 피로도 보다 최소 필요 피로도가 크다면
            if (visited[i] || dungeons[i][0] > hp) continue;
            // 방문 배열 체크
            visited[i] = true;
            // 방문 던전 수를 추가, 피로도 - 소모 피로도, 던전 배열 재귀 시작
            dfs(depth + 1, hp - dungeons[i][1], dungeons);
            // 방문 배열 미 방문으로 변경
            visited[i] = false;
        }
        count = Math.max(count, depth);
    }
}