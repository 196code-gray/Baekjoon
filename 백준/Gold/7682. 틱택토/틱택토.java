import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static String s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            map = new char[3][3];
            String s = br.readLine();
            if (s.equals("end")) break;

            int onum, xnum; onum = xnum = 0;
            boolean owin, xwin; owin = xwin = false;

            for (int i = 0; i < 9; i ++){
                map[i/3][i%3] = s.charAt(i);  // map 에 현 상황 저장
                if (s.charAt(i) == 'O') onum++;
                else if (s.charAt(i) == 'X') xnum++;
            }

            owin = checkO();
            xwin= checkX();

            if (xwin && !owin && xnum - onum == 1) System.out.println("valid");
            else if (!xwin && owin && onum == xnum) System.out.println("valid");
            else if (!xwin && !owin && xnum == 5 && onum == 4) System.out.println("valid");
            else System.out.println("invalid");
        }
    }
    static boolean checkO(){
        boolean reo = false;
        // 가로 3줄 확인
        for (int i = 0; i < 3; i++){
            if (map[i][0] == 'O' && map[i][0] == map[i][1] && map[i][1] == map[i][2]) reo = true;
        }
        // 세로 3줄 확인
        for (int i = 0; i < 3; i++){
            if (map[0][i] == 'O' && map[0][i] == map[1][i] && map[1][i] == map[2][i]) reo = true;
        }
        // 대각선 2줄 확인
        if (map[0][0] == 'O' && map[0][0] == map[1][1] && map[1][1] == map[2][2]) reo = true;
        if (map[0][2] == 'O' && map[0][2] == map[1][1] && map[1][1] == map[2][0]) reo = true;

        return reo;
    }
    static boolean checkX(){
        boolean rex = false;
        // 가로 3줄 확인
        for (int i = 0; i < 3; i++){
            if (map[i][0] == 'X' && map[i][0] == map[i][1] && map[i][1] == map[i][2]) rex = true;
        }
        // 세로 3줄 확인
        for (int i = 0; i < 3; i++){
            if (map[0][i] == 'X' && map[0][i] == map[1][i] && map[1][i] == map[2][i]) rex = true;
        }
        // 대각선 2줄 확인
        if (map[0][0] == 'X' && map[0][0] == map[1][1] && map[1][1] == map[2][2]) rex = true;
        if (map[0][2] == 'X' && map[0][2] == map[1][1] && map[1][1] == map[2][0]) rex = true;

        return rex;
    }
}