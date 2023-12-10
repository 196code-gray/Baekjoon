import java.io.*;
import java.util.*;

public class Main {
    static int n, sx, sy, ex, ey;   // 편의점, 시작x, 시작y, 끝x, 끝y
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());    // 편의점 개수
            List<int[]> list = new ArrayList<>();  // 편의점 좌표 저장
            for(int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    sx = x;
                    sy = y;
                } else if (j == n + 1) {
                    ex = x;
                    ey = y;
                } else {
                    list.add(new int[]{x,y});
                }
            }

            if (bfs(list)) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    static boolean bfs(List<int[]> list) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new int[] {sx, sy});

        while(!q.isEmpty()) {
            int[] store = q.poll();
            int px = store[0];
            int py = store[1];
            if(Math.abs(px- ex) + Math.abs(py- ey) <= 1000) {
                return true;
            }

            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    int nx = list.get(i)[0];
                    int ny = list.get(i)[1];
                    int dis = Math.abs(px - nx) + Math.abs(py - ny);
                    if(dis <= 1000) {
                        visited[i] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        return false;
    }
}