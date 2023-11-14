import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[] visited;   // 시간 저장 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[100_001];     // 시간 끝으로 선언
        System.out.println(BFS(n));
        }
        private static int BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;     // 맨 처음 방문했던 곳을 1초로 생각
        q.add(n);
        while (!q.isEmpty()) {      // 큐가 빌 때까지 반복
            int num = q.remove();
            if (num == k) {
                return visited[num] -1;     // 처음에 1초로 시작 했으므로 1초 빼주기 
            }
            if (num -1 >= 0 && visited[num -1] == 0) {      // 지정된 수에서 1초 뺀 경우
                visited[num -1] = visited[num] + 1;
                q.add(num -1);
            } if (num + 1 <= 100_000 && visited[num + 1] == 0) {        // 지정된 수에서 1초 더한 경우
                visited[num + 1] = visited[num] + 1;
                q.add(num + 1);
            } if (num * 2 <= 100_000 && visited[num * 2] == 0) {        // 지정된 수에서 2를 곱한 경우
                visited[num * 2] = visited[num] + 1;
                q.add(num * 2);
            }
        }
        return -1;
        }
    }