import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] arr;
    static boolean[] visit;
    static int[] check;
    static boolean isEven;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 1; i <= k; i++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            arr = new List[v + 1];
            visit = new boolean[v + 1];
            check = new int[v + 1];
            isEven = true;
            for (int j = 1; j <= v; j++) {
                arr[j] = new ArrayList<>();
            }
            for (int j = 0; j < e; j++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                arr[start].add(end);
                arr[end].add(start);
            }
            for (int j = 1; j <= v; j++) {
                if (isEven) DFS(j);
                else break;
            }
            if (isEven) System.out.println("YES");
            else System.out.println("NO");
        }

    }
    public static void DFS (int n) {
        visit[n] = true;    // 방문한 노드로 체크
        for (int i : arr[n]) {  // 인접 리스트로 받아서 n에서 연결된 모든 노드 탐색
            if (!visit[i]) {
                check[i] = (check[n] + 1) % 2;
                DFS(i);
            } else {
                if (check[n] == check[i]) {
                    isEven = false;
                }
            }
        }
    }
}