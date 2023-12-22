import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[15][15];
        for (int i = 1; i <= 14;i++){
            arr[0][i] = i;
        }
        while (t --> 0) {
            int k = Integer.parseInt(br.readLine()); int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= k;i++){
                for (int j = 1; j <= n; j++){
                    arr[i][j] = arr[i -1][j] + arr[i][j -1];
                }
            }
            System.out.println(arr[k][n]);
        }
    }
}