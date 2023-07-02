import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());
        long m = Integer.parseInt(br.readLine());
        long[] arr = new long[(int) n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = (int) (n -1);

        while (i < j) {
            if (arr[i] + arr[j] < m) {
                i++;
            } else if (arr[i] + arr[j] > m) {
                j--;
            } else if (arr[i] + arr[j] == m) {
                i++; j--; count++;
            }
        }
        System.out.println(count);
    }
}