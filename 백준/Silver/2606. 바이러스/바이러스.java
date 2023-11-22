import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count;   // 개수 저장
    static List<Integer> [] arr;    // 그래프 저장
    static boolean[] visited;   // 방문 여부
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    
        int m = Integer.parseInt(br.readLine());
        arr = new List[n + 1];  // 1부터 시작하기 때문에 n + 1
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        count = 0;
        visited = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            String[] s = br.readLine().split(" ");  // 띄어쓰기 기준으로 문자열 받기
            arr[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));    // 양방향이므로 서로 저장
            arr[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
        }
        BFS(1);     // 1부터 시작
        System.out.println(count);
    }
    static void BFS(int num) {
        Queue<Integer> q = new LinkedList<>();
        visited[num] = true;
        q.add(num);
        while (!q.isEmpty()) {      // 큐에 값이 없을때 까지
            int now = q.remove();
            for (int i : arr[now]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}