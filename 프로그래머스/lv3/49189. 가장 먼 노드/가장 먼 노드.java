import java.util.*;
class Solution {
    static List<Integer>[] arr;
    static boolean[] visited;
    static int answer;
    static int[] count;
    public int solution(int n, int[][] edge) {
        answer = 0;
        arr = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
                int s = edge[i][0];
                int e = edge[i][1];
                arr[s].add(e);
                arr[e].add(s);
        }
        count = new int[n + 1];
        bfs(1);

        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) max = count[i];
        }

        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) answer++;
        }
        return answer;
    }
    public static void bfs (int num) {
        Queue<Integer> q = new LinkedList<>();

        q.add(num);
        visited[num] = true;
        int nowNum = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count[i] = count[now] + 1;
                }
            }
        }
    }
}