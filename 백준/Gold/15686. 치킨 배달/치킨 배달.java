import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    static int[][] map;
    static boolean[] visited;
    static List<Store> chicken;
    static List<Home> home;
    static int n, m, ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        home = new ArrayList<>(); chicken = new ArrayList<>();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j= 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) home.add(new Home(i, j));
                else if (map[i][j] == 2) chicken.add(new Store(i, j));
            }
        }
        ans = Integer.MAX_VALUE; visited = new boolean[chicken.size()];
        distance(0,0);
        System.out.println(ans);
    }

    private static void distance(int s, int e) {
        if (e == m) {
            int r = 0;
            for (int i =0; i < home.size(); i++){
                int count = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++){
                    if (visited[j]) {
                        int dis = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        count = Math.min(count, dis);
                    }
                } r += count;
            }
            ans = Math.min(ans, r);
            return;
        }
        for (int i = s; i < chicken.size(); i++){
            visited[i] = true;
            distance(i + 1, e + 1);
            visited[i] = false;
        }
    }

    static class Store{
        int x;
        int y;

        public Store(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Home {
        int x;
        int y;

        public Home(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
