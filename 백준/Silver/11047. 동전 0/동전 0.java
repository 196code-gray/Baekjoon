import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 동전의 종류
        int k = sc.nextInt();   // 만들어야하는 최종 합
        int result = 0;
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        for (int i = n-1; i >= 0; i--) {
            if (coin[i] <= k) {
                result += (k / coin[i]);
                k = k % coin[i];
            }
        }
        System.out.println(result);
    }
}