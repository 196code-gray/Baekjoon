import java.io.*;
import java.util.*;

public class Main {
    static int su,k;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        su = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        bfs(su);
    }
    static void bfs(int s){
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{s, 0});
        boolean[] visit = new boolean[100_001];
        visit[s]=true;

        while (!q.isEmpty()){
            int[] now =q.poll();
            if(now[0]==k){
                System.out.println(now[1]);
                return;
            }
            int di = now[0]; int time=now[1];

            if(di*2<=100_000&&!visit[di*2]){
                visit[di*2]=true;
                q.offer(new int[]{di * 2, time});
            }
            if(di-1>=0&&!visit[di-1]){
                visit[di-1]=true;
                q.offer(new int[]{di - 1, time + 1});
            }
            if(di+1<=100_000&&!visit[di+1]){
                visit[di+1]=true;
                q.offer(new int[]{di + 1, time + 1});
            }
        }
    }
}