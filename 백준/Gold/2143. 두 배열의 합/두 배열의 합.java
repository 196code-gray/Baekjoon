import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());

        long[] a = new long[n];
        int alen = n*(n+1)/2;
        long[] aSum = new long[alen];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            a[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] b = new long[m];
        int blen = m*(m+1)/2;
        long[] bSum = new long[blen];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            b[i] = Long.parseLong(st.nextToken());
        }
        // a b 누적합
        for (int i = 1; i < n;i++) a[i] += a[i -1];
        for (int i = 1; i < m;i++) b[i] += b[i -1];
        // a의 부 배열의 누적합
        int idx = 0;
        for (int i = 0; i < n; i++){
            for (int j = i;j < n; j++){
                long now = a[j];
                if (i > 0) now -= a[i-1];
                aSum[idx++] = now;
            }
        }
        // b의 부 배열의 누적합
        idx = 0;
        for (int i = 0; i < m; i++){
            for (int j = i;j < m; j++){
                long now = b[j];
                if (i > 0) now -= b[i-1];
                bSum[idx++] = now;
            }
        }
        Arrays.sort(aSum);
        Arrays.sort(bSum);
        long count = 0;
        int s = 0;
        int e = blen-1;
        while (s < alen && e > -1) {
            long aNow = aSum[s], bNow = bSum[e];
            long ans = aNow + bNow;
            if (ans == t) {
                long ac =0, bc = 0;
                while (s < alen && aNow == aSum[s]){
                    s++;
                    ac++;
                }
                while (e > -1 && bNow == bSum[e]){
                    e--;
                    bc++;
                }
                count += ac*bc;
            }
            if (ans > t) e--;
            else if (ans < t){
                s++;
            }
        }
        System.out.println(count);
    }
}