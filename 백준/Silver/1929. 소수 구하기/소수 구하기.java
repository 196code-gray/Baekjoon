import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[n+1];

            for (int i = 2; i <= n; i++) {
                arr[i] = i;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (arr[i] == 0) continue;
                for (int j = i + i; j <= n; j = j + i) {
                    arr[j] = 0;
//                    if (arr[j] % i == 0 && arr[j] != i) {
//                        arr[j] = 0;
//                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (i >= m && i <= n) {
                    if (arr[i] != 0) {
                        System.out.println(arr[i]);
                    }
                }
            }

        }
    }