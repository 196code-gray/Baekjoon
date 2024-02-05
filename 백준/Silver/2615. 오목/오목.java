import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[19][19];
        int[][] now = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int count = 1;
                        int a = i;
                        int b = j;

                        while (true) {
                            a += now[k][0];
                            b += now[k][1];

                            if (a >= 0 && a < 19 && b >= 0 && b < 19) {
                                if (map[i][j] == map[a][b]) count++;
                                else break;
                            } else break;
                        }
                        a = i;
                        b = j;

                        while (true) {
                            a -= now[k][0];
                            b -= now[k][1];

                            if (a >= 0 && a < 19 && b >= 0 && b < 19) {
                                if (map[i][j] == map[a][b]) count++;
                                else break;
                            } else break;
                        }
                        if (count == 5) {
                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}