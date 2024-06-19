import java.util.*;
import java.io.*;

class Main {
    static int[][] map, update;
    static int[] input = new int[3];
    static int n, m;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][m];
        update = new int[m][m];
        for (int i = 0; i < m; i++)
            Arrays.fill(map[i], 1);

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            input[2] = Integer.parseInt(st.nextToken());
            int target = 0;

            for (int i = m - 1; i >= 0; i--) {
                while(input[target] == 0) target++;
                int now = target;
                map[i][0] += now;
                update[i][0] = now;
                input[target]--;
            }

            for (int i = 1; i < m; i++) {
                if(input[target] == 0) target++;
                int now = target;
                map[0][i] += now;
                update[0][i] = now;
                input[target]--;
            }

            change();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++)
                sb.append(map[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void change() {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] += Math.max(update[i][j - 1], Math.max(update[i - 1][j - 1], update[i - 1][j]));
                update[i][j] = Math.max(update[i][j - 1], Math.max(update[i - 1][j - 1], update[i - 1][j]));
            }
        }
    }
}
