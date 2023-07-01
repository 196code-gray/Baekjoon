import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long count = 1;
        long sum = 1;
        long start = 1;
        long end = 1;

        while (end != n) {
            if (sum < n) {
                end++; sum = end + sum;
            } else if (sum > n) {
                sum = sum - start; start++;
            } else if (sum == n) {
                end++; sum = end + sum;
                count++;
            }
        }
        System.out.println(count);
    }
}