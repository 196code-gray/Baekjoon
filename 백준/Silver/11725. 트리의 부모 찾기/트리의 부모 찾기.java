import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;    // 그래프 저장 배열 리스트
    static boolean[] visited;       // 방문 여부
    static int n;       // 노드 개수
    static int[] parent;        // 부모 저장 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) { 
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        DFS(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    static void DFS(int index) {
        visited[index] = true;      // 현재 노드 방문 체크
        for (int i : list[index]) {
            if (!visited[i]) {      // 한번도 들리지 않은 노드라면
                parent[i] = index;  // 자식 노드 배열에 현재 노드(부모) 저장
                DFS(i);
            }
        }
    }
}