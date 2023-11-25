import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        // greedy 알고리즘 = 최적의 경로 찾기
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int max = 0;
            Arrays.sort(arr);
            for (int i = arr.length - 1; i >= 2; i--) {
                if (arr[i] < arr[i -1] + arr[i - 2]) {
                    max = Math.max(max, arr[i] + arr[i -1] + arr[i -2]);
                }
            }
            System.out.println((max == 0) ? "-1" : max);
        }
    }