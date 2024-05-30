import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static long mod = 1_000_000_007, temp = 1, p = 0, m = 0;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long[] pow = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            pow[i] = temp - 1;
            temp = (temp * 2) % mod;
        }

        Arrays.sort(arr);

        for (int i = n - 1; i > 0; i--) {
            p += pow[i] * arr[i];
            m += pow[i] * arr[n - 1 - i];
            p %= mod;
            m %= mod;
        }

        System.out.println((p % mod + mod - m % mod) % mod);
    }
}