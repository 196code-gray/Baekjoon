import java.util.*;

public class Main {
    public static double harmonic(double n) {
        double sum = 0;
        for (double i = 1; i <= n; i++) {
            sum += 1 / i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double ans = n * harmonic(n);
        System.out.println(ans);
        scanner.close();
    }
}
