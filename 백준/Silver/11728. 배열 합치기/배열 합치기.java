import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n + m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n + m; i++) {
            if (i == n) st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            arr[i] = a;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb);
    }
}