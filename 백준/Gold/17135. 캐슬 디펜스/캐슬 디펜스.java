import java.util.*;
import java.io.*;

public class Main {
    static int n, m, D, ans;
    static int[] gungsu = new int[3];
    static int[][] map, copy;
    static List<Enemy> e;
    static public class Enemy implements Comparable<Enemy> {
        int x, y, dist;

        public Enemy(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Enemy o) {
            if (dist == o.dist) { // 거리가 같을 시 왼쪽에 있는 적 제거
                return y - o.y;
            }
            return  dist - o.dist; // 거리가 가까운 적 제거
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1]; copy = new int[n + 1][m + 1]; // n + 1에서부터 시작하기 때문에 0-n까지
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j= 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); // 현재 적 위치 기록
            }
        }

        ans = 0;
        dfs(0, 0);
        System.out.println(ans);
    }
    static void dfs(int depth, int idx){
        if (depth == 3){ // 궁수 위치를 다 결정
            gameStart();
            return;
        }
        for (int i = idx; i < m; i++){
            gungsu[depth] = i; // 현재 차례에 해당하는 위치
            dfs(depth + 1, i + 1);
        }
    }
    static void gameStart(){ // 게임 시작
        int delete = 0;
        copyMap(); // 지도 복사
        int[][] location; // 현재 궁수에 해당하는 적 위치 저장
        for (int i = n; i > 0; i--){ // 맨 밑부터 적 제거
            int turn = 3;
            int now = 0;  // 현재 궁수
            location = new int[3][2];
            for (int j = 0; j < 3; j++) Arrays.fill(location[j], -1);
            boolean[] visit = new boolean[3]; // 현재 궁수가 제거할 적이 있는지 체크
            while (turn -- > 0){
                e = new LinkedList<>(); // 리스트 초기화
                for (int d = i - 1; d >= i - D && d >=0; d--){ // 현재 거리에서 가능한 범위까지
                    for (int j= 0; j < m; j++){   // 첫 열부터 끝열까지
                        if (copy[d][j] == 1) { // 적이 있다면
                            int di = dist(d, i, j, gungsu[now]);
                            if (di > D) continue; // 현재 갈 수 있는 위치라면
                            e.add(new Enemy(d,j, di));
                        }
                    }
                }
                if (e.isEmpty()) {
                    now++; // 다음 궁수로
                    continue; // 현재 궁수가 제거가능한 적이 없을 경우
                }
                Collections.sort(e);
                location[now][0] = e.get(0).x; location[now][1] = e.get(0).y; // 제일 가까운 적 저장
                now++;
            }
            for (int[] a : location) {
                if (a[0] == -1 || a[1] == -1) continue;
                if (copy[a[0]][a[1]] == 1) {
                    copy[a[0]][a[1]] = 0;
                    delete++;
                }
            }
        }
        ans = Math.max(ans, delete);
    }
    static int dist(int r1, int r2, int c1, int c2){
        return Math.abs(r1- r2) + Math.abs(c1 - c2);
    }
    static void copyMap(){
        for (int i = 0; i < n; i++){
            for (int j= 0; j < m; j++){
                copy[i][j]= map[i][j];
            }
        }
    }
}