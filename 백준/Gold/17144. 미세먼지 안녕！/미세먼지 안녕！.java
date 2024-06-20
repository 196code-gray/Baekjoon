import java.util.*;
import java.io.*;

class Main {
    static int[][] room = new int[51][51], update;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int up, down, R, C, T;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st =new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        up = down = 0;

        for (int i = 1; i<= R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<= C; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1 && up == 0)
                    up = i;
                else if (room[i][j] == -1 && up != 0)
                    down = i;
            }
        }

        while(T --> 0){
            move(); // 미세먼지 이동

            wind(); // 공기청정기 바람
        }

        int ans = 0;
        for (int i = 1; i <= R; i++)
            for (int j = 1; j <= C;j++)
                if (room[i][j] > 0) ans += room[i][j];

        System.out.println(ans);
    }
    // 미세먼지 이동
    static void move(){
        update = new int[51][51];
        update[up][1] = update[down][1] = -1;
        for (int i = 1; i <= R; i++){
            for (int j = 1; j <= C; j++){
                if (room[i][j] > 0){
                    int dust = (int) Math.floor((double) room[i][j] / 5);
                    int cnt = 0;

                    for (int k = 0; k < 4; k++){
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;
                        if (nx <= 0 || ny <= 0 || nx > R || ny > C) continue;
                        if (room[nx][ny] == -1) continue;
                        cnt++;
                        update[nx][ny] += dust;
                    }

                    int now = room[i][j] - (dust * cnt);
                    update[i][j] += now;
                }
            }
        }

        // 미세먼지 room에 옮기기
        for (int i = 1; i <= R; i++)
            room[i] = update[i];
    }
    // 공기청정기 작동
    static void wind(){
        up();

        down();
    }

    private static void down() {
        int ls = room[down][C];
        for (int i = C; i > 2; i--)
            room[down][i] = room[down][i -1];
        room[down][2] = 0;
        int rs = room[R][C];
        for (int i = R; i > down + 1; i--)
            room[i][C] = room[i -1][C];
        room[down + 1][C] = ls;
        int ld = room[R][1];
        for(int i = 1; i < C -1; i++)
            room[R][i] = room[R][i + 1];
        room[R][C-1] = rs;
        for (int i = down + 1; i < R- 1;i++)
            room[i][1] = room[i + 1][1];
        room[R-1][1] = ld;
    }

    private static void up() {
        int side = room[up][C];
        for (int i = C; i >= 3; i--)
            room[up][i] = room[up][i -1];
        room[up][2] = 0;
        int rs = room[1][C];
        for (int i = 1; i < up -1; i++)
            room[i][C] = room[i + 1][C];
        room[up - 1][C] = side;
        int ls = room[1][1];
        for (int i = 1; i < C-1;i++)
            room[1][i] = room[1][i + 1];
        room[1][C- 1] = rs;
        for (int i = up -1; i > 2; i--)
            room[i][1] = room[i  -1][1];
        room[2][1] = ls;
    }
}