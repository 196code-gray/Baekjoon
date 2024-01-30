import java.io.*;
import java.util.*;

public class Main {
    static int s, ans;
    static boolean[][] visited;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        visited = new boolean[1000 * 2 + 1][1000 * 2 + 1];
        ans = 0;
        a = new int[1000 * 2 + 1];
        bfs();
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited[1][0] = true;
        q.offer(new int[]{1, 0, 0});
        a[1] = 0;

        while (!q.isEmpty()){
            int[] now = q.poll();
            int count = now[0];
            int stat = now[1];
            ans = now[2];

            a[count] = ans;

            if (count == s){    // 만들어야 하는 개수와 같은 경우
                System.out.println(ans);
                return;
            }
            int ctrlV = count + stat;
            if (ctrlV <= 1000 * 2 && !visited[ctrlV][stat]){
                q.offer(new int[]{ctrlV, stat, a[count] + 1});
                visited[ctrlV][stat] = true;
            }
            ctrlV = count -1;
            if (ctrlV >= 0 && !visited[ctrlV][stat]){
                visited[ctrlV][stat] = true;
                q.offer(new int[]{ctrlV, stat, a[count] + 1});
            }
            ctrlV = count;
            stat = count;
            if (ctrlV <= 1000 * 2 && !visited[ctrlV][stat]){
                q.offer(new int[]{ctrlV, stat, a[count] + 1});
                visited[ctrlV][stat] = true;
            }
        }
    }
}