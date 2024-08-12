import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            if (n == 0 && k == 0)
                break;
            
            long ans = 1;
            
            if (k > n / 2)
                k = n - k;
            
            for (int i = 1; i <= k; i++) {
                ans *= n;
                ans /= i;
                n--;
            }
            
            System.out.println(ans);
        }
        
        scanner.close();
    }
}