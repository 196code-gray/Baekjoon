import java.io.*;
import java.util.*;

public class Main {
    static int[] people;    // 지역 인구수
    static List<Integer>[] list;    // 연결 리스트
    static int n, ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n +1];
        list = new List[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= n /2; i++){
            dfs(1, i, new ArrayList<Integer>());
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    static void dfs(int idx, int end, ArrayList<Integer> first){
        if (end == 0){
            check(first);
            return;
        }
        for (int i = idx; i <= n; i++){
            first.add(i);
            dfs(i +1, end -1, first);
            first.remove(first.size() -1);
        }
    }
    static void check(ArrayList<Integer> first){
        if (!bfs(first, first.get(0))) return;

        ArrayList<Integer> B = new ArrayList<>();
        for (int i =1; i <= n; i++){
            if (!first.contains(i)) B.add(i);
        }

        if (!bfs(B, B.get(0))) return;
        int a,b; a = b = 0;
        for (int i = 1; i <= n; i++){
            if (first.contains(i)) {
                a += people[i];
            }
            else if (B.contains(i)){
                b += people[i];
            }
        }
        ans = Math.min(ans, Math.abs(a-b));

    }
    static boolean bfs(ArrayList<Integer> created, int now){
        Queue<Integer> q = new LinkedList<>();
        q.offer(now);
        boolean[] visited = new boolean[n +1];
        visited[now] = true;
        int count = 1;

        while (!q.isEmpty()){
            int ln = q.poll();

            for (Integer i : list[ln]) {
                if (!visited[i] && created.contains(i)){
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        if (count == created.size()) return true;
        else return false;
    }
}