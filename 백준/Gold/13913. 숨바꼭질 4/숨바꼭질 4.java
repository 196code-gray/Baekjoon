import java.io.*;
import java.util.*;

public class Main {
    static int n, e;
    static int[] node, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        node = new int[100001]; time = new int[100001];
        bfs(n);

        Stack<Integer> s = new Stack<>();
        s.push(e);
        int i = e;
        while (i != n){
            s.push(node[i]);
            i = node[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time[e] -1 + "\n");
        while (!s.isEmpty()){
            sb.append(s.pop() + " ");
        }
        System.out.println(sb.toString());
    }


    private static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        time[num] = 1;
        q.offer(num);
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == e) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                int minus;

                if (i == 0) minus = now - 1;
                else if (i == 1) minus = now + 1;
                else minus = now * 2;

                if (minus < 0 || minus > 100000) continue;

                if (time[minus] == 0) {
                    q.add(minus);
                    time[minus] = time[now] + 1;
                    node[minus] = now;
                }

            }
        }
    }
}