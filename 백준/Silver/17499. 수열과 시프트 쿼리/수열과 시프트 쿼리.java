import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long[] arr = new long[200020];
        int s = 0;

        st = new StringTokenizer(br.readLine()); 
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine()); 
            int x = Integer.parseInt(st.nextToken());
            if (x == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                a--;
                arr[(s + a) % n] += b;
            } else if (x == 2) {
                int a = Integer.parseInt(st.nextToken());
                s = (s + n - a) % n;
            } else {
                int a = Integer.parseInt(st.nextToken());
                s = (s + a) % n;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[(s + i) % n] + " ");
        }
        System.out.println();
    }
}