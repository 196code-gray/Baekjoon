import java.io.*;
import java.util.*;

    public class Main {
        static long[] arr;
        static long[] a;
        static long result;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            arr = new long[n+1];
            a = new long[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            result = 0;
            plus_sort(1, n);

            System.out.println(result);
        }
        public static void plus_sort(int s, int e) {
            if (e - s < 1) {
                return;
            }
            int m = s + (e - s) / 2;
            // 재귀 시작
            plus_sort(s, m); // 시작부터 중간까지
            plus_sort(m + 1, e); // 중간부터 끝까지
            for (int i = s; i <= e; i++) {
                a[i] = arr[i];
            }
            int k = s;
            int index1 = s;
            int index2 = m + 1;
            // 두 그룹을 병합
            while (index1 <= m && index2 <= e) {
                if (a[index1] > a[index2]) {
                    arr[k] = a[index2];
                    result = result + index2 - k;
                    k++;
                    index2++;
                } else {
                    arr[k] = a[index1];
                    k++;
                    index1++;
                }
            }
            while (index1 <= m) {
                arr[k] = a[index1];
                k++;
                index1++;
            }
            while (index2 <= e) {
                arr[k] = a[index2];
                k++;
                index2++;
            }
        }
    }