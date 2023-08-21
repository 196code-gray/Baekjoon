import java.util.*;

public class Main {
    static int n, m, k, x;
    static int[] visit;
    static List<Integer>[] arr;
    static List<Integer> result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        arr = new List[n + 1];
        visit = new int[n + 1];
        result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e); 
        }
        for (int i = 0; i <= n; i++) {
            visit[i] = -1;
        }
        BFS(x);
        for (int i = 0; i <= n; i++) {
            if (visit[i] == k) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(result);
            for (int a : result) {
                System.out.println(a);
            }
        }
    }
    private static void BFS (int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x]++;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int num : arr[now]) {
                if (visit[num] == -1) {
                    visit[num] = visit[now] + 1;
                    q.add(num);
                }
            }
        }
    }
}