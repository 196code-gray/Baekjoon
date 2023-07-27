import java.util.*;

    public class Main {
        static ArrayList<Edge> [] arr;
        static boolean[] visit;
        static int[] distance;
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int v = sc.nextInt();

            arr = new ArrayList[v + 1];
            visit = new boolean[v + 1];
            distance = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < v; i++) {
                int s = sc.nextInt();
                while (true) {
                    int e = sc.nextInt();
                    if (e == -1) break;
                    int w = sc.nextInt();
                    arr[s].add(new Edge(e, w));
                }
            }
            Bfs(1);
            int max = 1;
            for (int i = 2; i <= v; i++) {
                if (distance[max] < distance[i]) {
                    max = i;
                }
            }
            distance = new int[v + 1];
            visit = new boolean[v + 1];

            Bfs(max);

            Arrays.sort(distance);
            System.out.println(distance[v]);

        }
        static public void Bfs (int n) {
            Queue<Integer> q = new LinkedList<>();
            q.add(n);
            visit[n] = true;
            distance[n] = 0;
            while (!q.isEmpty()) {
                int now = q.poll();
                for (Edge i : arr[now]) {
                    int a = i.e;
                    int b = i.value;
                    if (!visit[a]) {
                        visit[a] = true;
                        q.add(a);
                        distance[a] = distance[now] + b;
                    }
                }
            }
        }
    }

    class Edge {
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }