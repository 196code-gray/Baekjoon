import java.util.*;

public class Main {
    static final long MOD = 1000000007;

    public static long powerModular(long X, long Y) {
        long result = 1;
        while (Y > 0) {
            if (Y % 2 == 1) {
                result = result * X % MOD;
            }
            X = X * X % MOD;
            Y /= 2;
        }
        return result;
    }

    public static long getP(long N) { return 4 * N - 4; }
    public static long getQ(long N) { return 24 * N - 48; }
    public static long getR(long N) { return 12 * N - 16; }
    public static long getS(long N) { return 48 * N - 72; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();

        long P = getP(N);
        long Q = getQ(N);
        long R = getR(N);
        long S = getS(N);

        long surfaceArea = S * powerModular(P, M - 1) % MOD;
        surfaceArea = (surfaceArea + (Q * R % MOD) * powerModular(R - P, MOD - 2) % MOD 
            * (powerModular(R, M - 1) - powerModular(P, M - 1) + MOD) % MOD) % MOD;

        long volume = powerModular(R, M);

        System.out.println(volume + " " + surfaceArea);
        sc.close();
    }
}