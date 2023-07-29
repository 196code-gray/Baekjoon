import java.io.*;
import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            int s = 0;
            int e = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (s < arr[i]) s = arr[i];
                e += arr[i];
            }

            while (s <= e) {
                int mid = (s+e) / 2;
                int count = 0;
                int now = 0;
                for (int i = 0; i < n; i++) {
                if (now + arr[i] > mid) {
                        count++;
                        now = 0;
                    }
                now += arr[i];
                }
                if (now != 0) count++;
                if (count > m) s = mid + 1;
                else e = mid -1;
            }

            System.out.println(s);

        }
    }