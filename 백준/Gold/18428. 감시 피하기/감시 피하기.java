import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String[][] map;
    static List<int[]> teacher;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        map = new String[n][n]; teacher = new ArrayList<>();
        for (int i = 0;i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = st.nextToken();
                // 선생님 수 카운트
                if (map[i][j].equals("T")) {
                    teacher.add(new int[]{i, j});
                }
            }
        }
        for (int[] i : teacher) {
            int x = i[0];
            int y = i[1];
            if (x + 1 < n && y < n && x + 1 >= 0 && y >= 0) {
                if (map[x + 1][y].equals("S")) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
            if (x - 1 < n && y < n && x - 1 >= 0 && y >= 0) {
                if (map[x - 1][y].equals("S")) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
            if (x< n && y-1 < n && x >= 0 && y-1 >= 0) {
                if (map[x][y-1].equals("S")) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
            if (x< n && y+1 < n && x >= 0 && y+1 >= 0) {
                if (map[x][y+1].equals("S")) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }

        dfs(0);
        System.out.println("NO");
    }
    static void dfs(int depth){
        if (depth == 3){
            if (check()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < n; i++){
            for (int j= 0; j < n; j++){
                if (map[i][j].equals("X")){
                    map[i][j] = "O";
                    dfs(depth + 1);
                    map[i][j] = "X";
                }
            }
        }
    }
    static boolean check(){
        for (int[] te : teacher){
            int x = te[0];
            int y = te[1];

            for (int i = x; i < n; i++){    // 하
                if (map[i][y].equals("O")) break;
                if (map[i][y].equals("S")) return false;
            }

            for (int i = y; i < n; i++){ //  오
                if (map[x][i].equals("O")) break;
                if (map[x][i].equals("S")) return false;
            }
            for (int i = x; i >= 0; i--){ // 위
                if (map[i][y].equals("O")) break;
                if (map[i][y].equals("S")) return false;
            }
            for (int i = y; i >= 0; i--){ // 왼
                if (map[x][i].equals("O")) break;
                if (map[x][i].equals("S")) return false;
            }
        }
        return true;
    }
}