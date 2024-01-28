import java.io.*;
import java.util.*;

public class Main {
    static int[][] people;
    static int n, m, ans;
    static int[] order;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        people = new int[n][m];

        for (int i = 0; i < n; i++){
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) people[i][j] = Integer.parseInt(st.nextToken());
        }
        order = new int[3];
        ans = 0;

        dfs(0, 0);

        System.out.println(ans);
    }
    static void dfs(int depth, int idx){
        if (depth == 3){
            like();
            return;
        }

        for (int i = idx; i < m; i++){
            order[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    private static void like() {
        int score = 0;
        for (int i = 0; i < n; i++){
            score += Math.max(people[i][order[0]], Math.max(people[i][order[1]], people[i][order[2]]));
        }
        ans = Math.max(ans, score);
    }
}