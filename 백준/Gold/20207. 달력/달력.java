import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int n;
    static int[][] cal = new int[2][367];
    static long ans;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        while(n --> 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int i = s; i <= e; i++)
                cal[1][i]++;
        }

        ans = 0;
        for (int i = 1; i <= 365; i++){
            int idx = i; int max = 0;
            while (cal[1][idx] != 0){
                max = cal[1][idx] > max ? cal[1][idx] : max;
                idx++;
            }

            if (max != 0)
                ans += (long) max * (idx - i);
            i = idx;
        }
        System.out.println(ans);
    }
}