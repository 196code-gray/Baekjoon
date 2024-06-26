import java.util.*;
import java.io.*;

class Main{
    static BufferedReader br;
    static int n, m, ans;
    static boolean[] book;
    static PriorityQueue<int[]> q;
    static StringTokenizer st;
    public static void main(String[] args)throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            q = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1])
                        return o1[0] - o2[0];
                    else return o1[1] - o2[1];
                }
            });
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

            book = new boolean[1001];
            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                q.offer(new int[]{a, b});
            }

            ans =0;
            for (int i = 0;i < m; i++){
                int[] now = q.poll();
                int a = now[0];
                int b = now[1];
                while(a <= b){
                    if (!book[a]){
                        book[a] = true;
                        ans++;
                        break;
                    }
                    a++;
                }
            }
            System.out.println(ans);
        }
    }
}