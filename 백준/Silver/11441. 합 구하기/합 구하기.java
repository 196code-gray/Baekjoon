import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            sum[i] = sum[i -1] + Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M --> 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(sum[e] - sum[s -1]).append("\n");
        }
        System.out.println(sb);
    }
}