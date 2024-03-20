import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int r = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, -1});

        double max = 0;
        ArrayList<ArrayList<Integer>> tower = new ArrayList<>();
        boolean[][] visit = new boolean[1001][1001];
        for (int i = 0; i <= 1000; i++) tower.add(new ArrayList<>());
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            tower.get(x1).add(y1);
        }
        visit[x][y] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x1 = now[0];
            int y1 = now[1];
            int dist = now[2];

            for (int i = x1 - r; i <= x1 + r; i++){
                if (i < 0) i = 0;
                else if (i > 1000) break;

                for (Integer y2 : tower.get(i)) {
                    double distance = Math.sqrt(Math.pow(x1 - i, 2) + Math.pow(y1 - y2, 2));
                    if (!visit[i][y2] && distance <= r){
                        q.offer(new int[]{i, y2, dist + 1});
                        max += d / Math.pow(2, dist + 1);
                        visit[i][y2] = true;
                    }
                }
            }
        }
        System.out.println(max);
    }
}