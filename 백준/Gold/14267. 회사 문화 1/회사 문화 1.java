import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static ArrayList<Integer>[] list = new ArrayList[100_001];
    static int[] total = new int[100_001];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n;i++){
            int num = Integer.parseInt(st.nextToken());
            if (i == 1) continue;
            list[num].add(i);
        }

        for (int i = 0;i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            total[s] += score;
        }
        DFS(1);

        for (int i = 1; i <= n; i++) System.out.print(total[i] + " ");
    }
    static void DFS(int now){
        for (Integer i : list[now]){
            total[i] += total[now];
            DFS(i);
        }
    }
}