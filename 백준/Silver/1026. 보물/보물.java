import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b.length; i++) {
             b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        for (int i = 0; i < b.length; i++) {
            ans += (a[i] * b[i]);
        }
        System.out.println(ans);
    }
}