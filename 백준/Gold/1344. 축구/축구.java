import java.util.*;
import java.lang.Math;

public class Main {

    static final int N = 19;
    static List<Integer> range = Arrays.asList(0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18);
    static int[] C = new int[N];

    static void initBC() {
        int n = N;
        C[0] = C[1] = 1;
        for (int i = 2; i < n; ++i) {
            C[0] = C[i] = 1;
            for (int j = i - 1; j > 0; --j) {
                C[j] += C[j - 1];
            }
        }
    }

    static double solve(double a, double b) {
        initBC();
        a /= 100;
        b /= 100;

        double Sa = 0, Sb = 0;
        for (int r : range) {
            Sa += C[r] * Math.pow(a, r) * Math.pow(1 - a, N - 1 - r);
            Sb += C[r] * Math.pow(b, r) * Math.pow(1 - b, N - 1 - r);
        }
        return 1 - Sa * Sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.println(solve(a, b));
        sc.close();
    }
}