import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] friend, hate;
    static boolean[] team;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine()); m = Integer.parseInt(br.readLine());
        friend = new ArrayList[n + 1]; hate = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            friend[i] = new ArrayList<>(); hate[i] = new ArrayList<>();
        }
        for (int i = 0;i < m; i ++){ // 친구와 원수 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (s.equals("E")) {
                hate[a].add(b);
                hate[b].add(a);
            }
            else {
                friend[a].add(b);
                friend[b].add(a);
            }
        }
        team = new boolean[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++){ // 한 친구씩 확인
            if (!team[i]){
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }
    static void dfs(int s){
        team[s] = true;
        for (int i : friend[s]){
            if (!team[i]){
                dfs(i);
            }
        }
        for (int i : hate[s]){
            for (int j : hate[i]){
                if (!team[j]) dfs(j);
            }
        }
    }
}