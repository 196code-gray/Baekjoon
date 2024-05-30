import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map, change;
    static int n, t, d;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t --> 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); d = Integer.parseInt(st.nextToken());
            map = new int[n][n]; change = new int[n][n];

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    change[i][j] = map[i][j];
                }
            }

            if (Math.abs(d) == 360) {
                save();
            } else {
                int now = d;

                if (now < 0) now = 360 - (-d);

                now /= 45;

                while (now --> 0) {
                    turn();
                }

                save();
            }
        }
        System.out.println(sb);
    }

    private static void save() {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }
    static void turn(){
        for (int i = 0; i < n / 2; i++){
            change[i][n / 2] = map[i][i]; // 처음 왼대
            change[i][n -1 -i] = map[i][n / 2];  // 위쪽 가운데
            change[n/2][n -1 - i] = map[i][n -1 -i];  // 처음 오대
            change[n -1 -i][n -1- i] = map[n / 2][n -1 -i];  // 중간 오
            change[n - 1 - i][n / 2] = map[n - 1 - i][n -1- i]; // 아래 오대
            change[n -1 -i][i] = map[n -1 -i][n / 2];  // 아래 중간
            change[n / 2][i] =map[n -1-i][i]; // 아래 왼대
            change[i][i] = map[n / 2][i];  //
        }

        for (int i = 0; i < n ;i++){
            for (int j = 0; j < n ;j++){
                map[i][j] = change[i][j];
            }
        }
    }
}