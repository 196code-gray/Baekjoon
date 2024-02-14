import java.io.*;
import java.util.*;

public class Main {
    static int[] people;
    static int[][] card;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n + 1];
        card = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            dfs(i, 0, 0, 1);
        }
        int ans, score;
        ans = score = 0;

        for (int i = 1; i <= n; i++){
            if (score <= people[i]){
                score = people[i];
                ans = i;
            }
        }
        System.out.println(ans);
    }
    static void dfs(int turn, int score, int depth, int s){
        if (depth == 3){
            if (people[turn] < score % 10) people[turn] = score%10;
            return;
        }

        for (int i = s; i <= 5; i++){
            dfs(turn, score + card[turn][i] % 10, depth + 1, i +1);
        }
    }
}