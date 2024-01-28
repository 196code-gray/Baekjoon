import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] noChoice = new boolean[n][n];
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken()) -1;
            int two = Integer.parseInt(st.nextToken()) -1;
            noChoice[one][two] = true;
            noChoice[two][one] = true;
        }
        int ans = 0;
        for (int i = 0; i < n -1; i++){
            int[] choice = new int[3];
            choice[0] = i;
            for (int j = i + 1; j < n; j++){
                choice[1] = j;
                if (!noChoice[i][j]){
                    for (int k = j + 1; k < n; k++){
                        choice[2] = k;
                        if (!noChoice[i][k] && !noChoice[j][k]) ans++;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}