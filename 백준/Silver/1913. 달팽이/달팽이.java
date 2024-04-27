import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int x, y; x = y = n /2;
        StringBuilder sb = new StringBuilder();
        int num, limit; num = limit = 1;
        while (true){
            for (int i = 0; i < limit; i++){
                map[x--][y] = num++;
            }
            if (num -1 == n *n) break;
            for (int i = 0; i < limit; i++){
                map[x][y++] = num++;
            }
            limit++;

            for (int i = 0; i<limit; i++){
                map[x++][y] = num++;
            }
            for(int i =0; i < limit; i++){
                map[x][y--] = num++;
            }
            limit++;
        }
        int[] findn = new int[2];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == find) {
                    findn[0] = i + 1;
                    findn[1] = j + 1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(findn[0]).append(" ").append(findn[1]);
        System.out.println(sb);
    }
}