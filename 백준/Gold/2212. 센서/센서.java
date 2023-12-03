import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if (k >= n) {
            System.out.println(0);
            return ;
        }
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);       // 센서 위치 오름차순
        Integer[] num = new Integer[n - 1];
        for (int i = 0; i < n -1; i++) {
            num[i] = Math.abs(arr[i] - arr[i + 1]);
        }
        Arrays.sort(num, Collections.reverseOrder());   // 차이 배열 내림차순
        long answer = 0;
        for (int i = k -1; i < n -1; i++) {
            answer += num[i];
        }
        System.out.println(answer);
    }
}