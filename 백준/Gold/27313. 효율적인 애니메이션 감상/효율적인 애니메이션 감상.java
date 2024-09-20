import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        long[] v = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(v);
        
        int c = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < Math.min(k, n); i++) {
            if (v[i] > m) {
                System.out.println(c);
                return;
            }
            pq.add(-v[i]);
            c++;
        }

        for (int i = k; i < n; i++) {
            long x = -pq.poll(); 
            if (x + v[i] > m) {
                System.out.println(c);
                return;
            }
            pq.add(-(x + v[i]));
            c++;
        }
        
        System.out.println(c);
    }
}