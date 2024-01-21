import java.util.*;
import java.io.*;

public class Main {
    static int[] turn;
    static int[][] gear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];
        for (int i = 0; i < 4; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j < 8; j++){
                gear[i][j] = s[j].charAt(0) - '0';
            }
        }
        int m = Integer.parseInt(br.readLine());
        while (m --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) -1;
            int t = Integer.parseInt(st.nextToken());
            turn = new int[4];
            turn[num] = t;

            isGear(num);
            isTurn();
        }
        int ans = 0;
        if (gear[0][0] == 1) ans += 1;
        if (gear[1][0] == 1) ans += 2;
        if (gear[2][0] == 1) ans += 4;
        if (gear[3][0] == 1) ans += 8;
        System.out.println(ans);
    }

    private static void isTurn() {
        int now = 0;
        for (int i = 0; i < 4; i++){
            if (turn[i] == 1){
                now = gear[i][7];
                for (int j = 7; j > 0; j--){
                    gear[i][j]= gear[i][j-1];
                } gear[i][0] = now;
            }
            if (turn[i] == -1) {
                now = gear[i][0];
                for (int j = 0; j < 7; j++){
                    gear[i][j] = gear[i][j + 1];
                } gear[i][7] = now;
            }
        }
    }

    private static void isGear(int num) {
        for (int i = num -1; i >= 0; i--){
            if (gear[i][2] != gear[i + 1][6]){
                turn[i] = -turn[i+1];
            } else break;
        }
        for (int i = num + 1; i < 4; i++){
            if (gear[i][6] != gear[i - 1][2]){
                turn[i] = -turn[i -1];
            } else break;
        }
    }
}
