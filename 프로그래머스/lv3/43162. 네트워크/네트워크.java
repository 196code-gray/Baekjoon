import java.util.*;
class Solution {
        static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, computers);
                answer++;
            }
        }

        return answer;
    }
    public static void DFS (int num, int[][] computers) {
        visited[num] = true;
        for (int i = 0; i < computers[0].length; i++) {
            if (!visited[i] && computers[num][i] == 1) {
                DFS(i, computers);
            }
        }
    }
}