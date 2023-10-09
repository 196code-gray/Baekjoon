import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (start <= n && end <= n) {
            if (result >= s && min > end - start) min = end - start;
            if (result < s) result += arr[end++];
            else result -= arr[start++];
        }
        if (min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}