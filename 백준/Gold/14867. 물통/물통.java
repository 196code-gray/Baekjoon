import java.io.*;
import java.util.*;

public class Main {
    static class water{
        int x,y;

        public water(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());int B = Integer.parseInt(st.nextToken());
        int RA = Integer.parseInt(st.nextToken()); int RB = Integer.parseInt(st.nextToken());

        Map<water, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        map.put(new water(0, 0), 0);
        set.add("0_0");
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
            if (!set.contains(String.valueOf(A)+"_"+String.valueOf(y))){
                q.offer(new int[]{A, y, cnt+1});
                set.add(String.valueOf(A) + "_" + String.valueOf(y));
            }

            if (!set.contains(String.valueOf(x)+"_"+String.valueOf(B))){
                set.add(String.valueOf(x)+"_"+String.valueOf(B));
                q.offer(new int[]{x, B, cnt+1});
            }

            // E함수
            if (!set.contains("0_"+String.valueOf(y))){
                set.add("0_"+String.valueOf(y));
                q.offer(new int[]{0, y, cnt+1});
            }

            if (!set.contains(String.valueOf(x)+"_0")){
                set.add(String.valueOf(x)+"_0");
                q.offer(new int[]{x, 0, cnt+1});
            }

            // M함수
            if (x == A && y == B) continue;
            if (x != 0){
                int AB = (B - y) >= x ? x : (B-y);
                if (x - AB >= 0 && AB + y <= B && !set.contains(String.valueOf(x-AB)+"_"+String.valueOf(AB+y))) {
                    set.add(String.valueOf(x-AB)+"_"+String.valueOf(AB+y));
                    q.offer(new int[]{x - AB, AB + y, cnt+1});
                }
            }
            if (y != 0){
                int BA = (A - x) >= y ? y : A - x;
                if (x + BA <= A && y - BA >= 0 && !set.contains(String.valueOf(x+BA) + "_"+ String.valueOf(y -BA))){
                    map.put(new water(x + BA, y - BA), cnt+1);
                    set.add(String.valueOf(x+BA) + "_"+ String.valueOf(y -BA));
                    q.offer(new int[]{BA + x, y - BA, cnt+1});
                }
            }
        }
        System.out.println(-1);
    }
}