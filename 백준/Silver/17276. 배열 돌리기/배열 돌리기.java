import java.io.*;
import java.util.*;

public class Main {
    static int[][] copy, a;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  t= Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); int turn = Integer.parseInt(st.nextToken());
            a = new int[n][n]; copy = new int[n][n];
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = a[i][j];
                }
            }
            if (turn != 360) {
                if (turn < 0) turn += 360;
                turn /= 45;

                while (turn-- > 0) turnArr();
            }

            for (int i= 0;i < n; i++){
                for (int j= 0; j < n; j++) {
                    sb.append(a[i][j]).append(" ");
                } sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    static void turnArr(){
        for (int i = 0; i < n; i++){
            copy[i][n/2] = a[i][i];
            copy[i][i] = a[n/2][i];
            copy[n/2][i] = a[n - i -1][i];
            copy[n -i -1][i] = a[n -i -1][n/2];
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) a[i][j] = copy[i][j];
        }
    }
}