import java.io.*;
import java.util.*;

    public class Main {
        static ArrayList<Integer>[] arr;
        static boolean[] visit;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n +1];
            visit = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr[s].add(e);
                arr[e].add(s);
            }

            for (int i = 1; i <= n; i++) {
                Collections.sort(arr[i]);
            }

            dfs(v);
            System.out.println();
            visit = new boolean[n + 1];
            bfs(v);

        }
        static void dfs ( int v) {
            System.out.print(v + " ");
            visit[v] = true;
            for (int i : arr[v]) {
                if (!visit[i]) {
                    dfs(i);
                }
            }
        }
        static void bfs ( int v){
            Queue<Integer> q = new LinkedList<>();
            visit[v] = true;
            q.add(v);

            while (!q.isEmpty()) {
                int now = q.poll();
                System.out.print(now + " ");
                for (int i : arr[now]) {
                    if (!visit[i]) {
                        visit[i] = true;
                        q.add(i);
                    }
                }
            }

        }
    }