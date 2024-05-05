import java.io.*;
import java.util.*;

public class Main {
    static int[][] game = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},
            {2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
    static int[][] gameResult;
    static boolean s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 4;

        while(t --> 0){
            gameResult = new int[6][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = false; boolean possible = true;

            for(int i = 0; i < 6; i++){
                for (int j = 0; j < 3; j++){
                    gameResult[i][j] = Integer.parseInt(st.nextToken());
                }
                // 승리 + 무승부 + 패배 합쳐서 5가 아닌 경우 불가능
                if (gameResult[i][0] + gameResult[i][1] + gameResult[i][2] != 5) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.print(0 + " ");
                continue;
            }

            DFS(0);

            if (!s) System.out.print(0+ " ");
            else System.out.print(1+ " ");
        }
    }
    static void DFS(int depth){
        if (s){
            return;
        }
        if (depth == 15){
            s = true;
            return;
        }

        int team1 = game[depth][0];
        int team2 = game[depth][1];

        // 승 : 패
        if (gameResult[team1][0] > 0 && gameResult[team2][2] > 0){
            gameResult[team1][0]--;
            gameResult[team2][2]--;
            DFS(depth + 1);
            gameResult[team1][0]++;
            gameResult[team2][2]++;
        }
        // 무 : 무
        if (gameResult[team1][1] > 0 && gameResult[team2][1] > 0){
            gameResult[team1][1]--;
            gameResult[team2][1]--;
            DFS(depth + 1);
            gameResult[team1][1]++;
            gameResult[team2][1]++;
        }
        // 패 : 승
        if (gameResult[team1][2] > 0 && gameResult[team2][0] > 0){
            gameResult[team1][2]--;
            gameResult[team2][0]--;
            DFS(depth + 1);
            gameResult[team1][2]++;
            gameResult[team2][0]++;
        }
    }
}