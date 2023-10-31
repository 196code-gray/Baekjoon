import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }
        int max = sum;
        int count = 1;
        for (int i = x; i < arr.length; i++) {
            sum += arr[i] - arr[i - x];
            if (sum == max) count++;
            else if (max < sum) {
                max = Math.max(sum, max);
                count = 1;
            }
        }
        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}