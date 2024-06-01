import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int[] total = new int[100_001], people = new int[100_001];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n;i++){
            int num = Integer.parseInt(st.nextToken());
            if (i == 1) continue;
            people[i] = num;
        }

        for (int i = 0;i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            total[s] += score;
        }

        for (int i = 1; i <= n; i++){
            total[i] += total[people[i]];
        }

        for (int i = 1; i <= n; i++) System.out.print(total[i] + " ");
    }
}