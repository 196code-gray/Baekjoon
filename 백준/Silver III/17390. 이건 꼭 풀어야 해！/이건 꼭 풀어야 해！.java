import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sum);
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i-1];  //누적합
        }
        StringBuilder sb = new StringBuilder();
        while (m --> 0) {
            st = new StringTokenizer(br.readLine());
            int s,e;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            sb.append(sum[e]-sum[s-1]).append("\n");
        }
        System.out.println(sb);
    }
}