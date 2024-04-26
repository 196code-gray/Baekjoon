import java.io.*;
import java.util.*;

public class Main {
    static boolean[] use;
    static char[][] star;
    static ArrayList<Location> x;
    static int x_cnt;
    static public class Location{
        int x,y;

        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        use = new boolean[13];
        star = new char[5][9];
        x = new ArrayList<>();
        x_cnt =0;

        for (int i= 0; i < 5; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < 9; j++){
                star[i][j] = s[j].charAt(0);
                // 알파벳이라면 사용 체크
                if (star[i][j] - 'A' >= 0 && star[i][j] - 'A' < 13) use[star[i][j] - 'A' + 1] = true;
                // x라면 위치 & 개수 저장
                else if (star[i][j] == 'x'){
                    x.add(new Location(i, j));
                    x_cnt++;
                }
            }
        }

        DFS(0, 0);
    }
    static boolean check(){
        if ((star[0][4] - 'A' + 1) + (star[1][3]- 'A' + 1) + (star[2][2] - 'A' + 1)+ (star[3][1]- 'A' + 1) != 26) return false;
        if ((star[0][4]- 'A' + 1) + (star[1][5] - 'A' + 1) + (star[2][6]- 'A'+1)+ (star[3][7]- 'A'+ 1) != 26) return false;
        if ((star[1][1] - 'A' +1 ) + (star[1][3] - 'A' + 1) + (star[1][5] - 'A' + 1) + (star[1][7] - 'A' + 1) != 26) return false;
        if ((star[1][1] - 'A' + 1) + (star[2][2] - 'A' + 1) + (star[3][3]- 'A' + 1) + (star[4][4] - 'A' + 1) != 26) return false;
        if ((star[1][7] - 'A' + 1) + (star[2][6]- 'A' +1 ) +( star[3][5] - 'A' + 1) + (star[4][4] - 'A' +1) != 26) return false;
        if ((star[3][1] - 'A' + 1) + (star[3][3] - 'A' + 1) + (star[3][5] - 'A' +1) + (star[3][7] - 'A' +1) != 26) return false;

        return true;
    }
    static void DFS(int idx, int depth){
        if (depth == x_cnt){
            if (check()){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 9; j++){
                        System.out.print(star[i][j]);
                    }
                    System.out.println();
                }
                System.exit(0);
            } else return;
        }

        for (int i = 0; i < 12; i++){
            if (use[i + 1]) continue;
            use[i + 1] = true;
            star[x.get(idx).x][x.get(idx).y] = (char) (i + 'A');
            DFS(idx+1, depth+1);
            star[x.get(idx).x][x.get(idx).y] = 'x';
            use[i + 1] = false;
        }
    }
}