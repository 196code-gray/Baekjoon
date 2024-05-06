import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[4][4]; // 물고기 상태
        int[] fishDist = new int[17];  // 물고기 방향

        for (int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                fishDist[map[i][j]] = Integer.parseInt(st.nextToken());
            }
        }

        int fn = map[0][0]; int fd = fishDist[fn];
        fishDist[fn] = -1;
        DFS(0, 0, fd, fn, map, fishDist);
        System.out.println(ans);
    }
    static void DFS(int si, int sj, int dist, int sum, int[][] fish, int[] fDist){
        ans = Math.max(ans, sum);

        // 기존 물고기 위치&방향 복사
        int[][] nFish = new int[4][4];
        for (int i = 0;i < 4; i++){
            nFish[i] = fish[i].clone();
        }
        int[] nDist = new int[17];
        nDist = fDist.clone();

        // 물고기 이동
        move(si, sj, nFish, nDist);

        // 상어 방향대로 이동&재귀
        for (int i = 1; i <= 3; i++){
            int nx = si + dx[dist] * i;
            int ny = sj + dy[dist] * i;

            if (!check(nx, ny)) continue;
            if (nDist[nFish[nx][ny]] < 0) continue;
            // 물고기 방향이 범위 안인가
            int d = nDist[nFish[nx][ny]];
            int x = dx[d] + nx;
            int y = dy[d] + ny;
//            if (!check(x, y)) continue;

            int f = nFish[nx][ny];
            nFish[nx][ny] = 0;
            nDist[f] = -1;
            DFS(nx, ny, d, sum + f, nFish, nDist);
            nFish[nx][ny] = f;
            nDist[f] = d;
        }
    }
    static void move(int x, int y, int[][] newM, int[] nDist){
        boolean next = false;
        for (int k = 1; k <= 16; k++){ // 제일 작은 물고기부터 이동
            if(nDist[k] == -1) continue;  // 없는 물고기는 패스
            next = false;
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (newM[i][j] == k){  // 물고기를 찾은 경우
                        for (int w = 0; w <= 8; w++){
                            int now = w + nDist[k];
                            if (now > 8) now -= 8;
                            int nx = dx[now] + i;
                            int ny = dy[now] + j;
                            if (!check(nx, ny) || (nx == x && ny == y)) continue;
                            // 물고기 위치 변경
                            int fn = newM[nx][ny]; // 물고기 넘버
                            int fd = nDist[fn]; // 물고기 방향
                            newM[nx][ny] = k;
                            nDist[k] = now;
                            newM[i][j] = fn;
                            nDist[fn] = fd;
                            next = true;
                            break;
                        }
                    }
                    if (next) break;
                }
                if (next) break;
            }
        }
    }
    static boolean check(int nx, int ny){
        return (nx >= 0 && ny >= 0 && nx < 4 && ny < 4);
    }
}