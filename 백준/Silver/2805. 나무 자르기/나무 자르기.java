import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] arr = new long[(int) n];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        long min = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (max < arr[i]) max = arr[i];
        }
        while (max > min) {
            long sum = 0;
            long mid = (max + min) / 2;
            for (int i = 0; i < n; i++) {
                if (arr[i] - mid > 0) {
                    sum += (arr[i] - mid);
                }
            }
            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min -1);
    }
}