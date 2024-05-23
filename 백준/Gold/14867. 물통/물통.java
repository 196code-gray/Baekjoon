import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());int B = Integer.parseInt(st.nextToken());
        int RA = Integer.parseInt(st.nextToken()); int RB = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[A+1][B+1];
        visit[0][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];

            // 탈출
            if (x == RA && y == RB){
                System.out.println(cnt);
                return;
            }

            // F함수
            if (!visit[A][y]){
                visit[A][y] = true;
                q.offer(new int[]{A, y, cnt+1});
            }

            if (!visit[x][B]){
                visit[x][B] = true;
                q.offer(new int[]{x, B, cnt+1});
            }

            // E함수
            if (!visit[0][y]){
                visit[0][y] = true;
                q.offer(new int[]{0, y, cnt+1});
            }
            if (!visit[x][0]){
                visit[x][0] = true;
                q.offer(new int[]{x, 0, cnt+1});
            }

            // M함수
            if (x == A && y == B) continue;
            if (x != 0){
                int AB = (B - y) >= x ? x : (B-y);
                if (x - AB >= 0 && AB + y <= B && !visit[x-AB][AB+y]) {
                    visit[x - AB][AB + y] = true;
                    q.offer(new int[]{x - AB, AB + y, cnt+1});
                }
            }
            if (y != 0){
                int BA = (A - x) >= y ? y : A - x;
                if (x + BA <= A && y - BA >= 0 && !visit[x + BA][y -BA]){
                    visit[x + BA][y - BA] = true;
                    q.offer(new int[]{BA + x, y - BA, cnt+1});
                }
            }
        }
        System.out.println(-1);
    }
}