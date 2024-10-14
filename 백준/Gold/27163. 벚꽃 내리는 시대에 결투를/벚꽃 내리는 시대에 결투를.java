import java.util.*;

public class Main {
    static int n, pos, A, L, X;
    static int[] Y = new int[5001];
    static int[][] DP = new int[2][5001];
    static BitSet[] B = new BitSet[5001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        A = sc.nextInt();
        L = sc.nextInt();
        
        for (int i = 0; i <= L; i++) {
            DP[0][i] = A;
        }
        
        for (int i = 1; i <= n; i++) {
            X = sc.nextInt();
            Y[i] = sc.nextInt();
            
            int[] C = DP[i % 2];
            int[] P = DP[(i - 1) % 2];
            Arrays.fill(C, -1);
            
            if (X >= 0 && Y[i] >= 0) {
                for (int j = 1; j <= L; j++) {
                    F(C, P, j, P[j] - X);
                }
            } else if (X >= 0) {
                for (int j = 1; j <= L; j++) {
                    if (P[j] != -1) {
                        F(C, P, j, Math.max(P[j] - X, 0));
                    }
                }
            }
            
            if (Y[i] >= 0) {
                for (int j = Y[i] + 1; j <= L; j++) {
                    if (P[j] >= 0) {
                        C[j - Y[i]] = Math.max(C[j - Y[i]], P[j]);
                        if (C[j - Y[i]] == P[j]) {
                            if (B[i] == null) {
                                B[i] = new BitSet();
                            }
                            B[i].set(j - Y[i]);
                        }
                    }
                }
            }
        }
        
        for (int i = 1; i <= L; i++) {
            if (DP[n % 2][i] >= 0) {
                pos = i;
            }
        }
        
        if (pos != 0) {
            System.out.println("YES");
            Print(n, pos);
        } else {
            System.out.println("NO");
        }
        
        sc.close();
    }

    static void F(int[] C, int[] P, int j, int val) {
        C[j] = Math.max(C[j], val);
    }

    static void Print(int i, int j) {
        if (i == 0) return;
        if (B[i] != null && B[i].get(j)) {
            Print(i - 1, j + Y[i]);
            System.out.print('L');
        } else {
            Print(i - 1, j);
            System.out.print('A');
        }
    }
}