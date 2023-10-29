import java.util.Scanner;

public class Main {
    static final int NM = 200005;
    static int n;
    static int[] a = new int[NM];
    static int[][] dy = new int[NM][20];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int ans = 0;
        for (int k = 0; k <= 19; k++) {
            for (int i = 1; i <= n; i++) {
                if (a[i] == 1 && k == 0) {
                    dy[i][k] = i;
                } else if (a[i] == 2 && k == 1) {
                    dy[i][k] = i;
                } else if (k >= 1) {
                    if (dy[i][k - 1] != 0) {
                        if (dy[dy[i][k - 1] + 1][k - 1] != 0) {
                            dy[i][k] = dy[dy[i][k - 1] + 1][k - 1];
                        }
                    }
                }
                if (dy[i][k] != 0) {
                    ans = Math.max(ans, 1 << k);
                }
            }
        }

        System.out.println(ans);
    }
}
