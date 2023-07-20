import java.io.*;
import java.util.*;

    public class Main {
        static int n;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            dfs(2, 1);
            dfs(3, 1);
            dfs(5, 1);
            dfs(7, 1);
        }
        static void dfs ( int num, int a) {
            if (a == n) {
                if (isPrime(num)) {
                    System.out.println(num);
                }
                return;
            }
            for (int i = 1; i < 10; i++) {
                if (i % 2 == 0) {
                    continue;
                }
                if (isPrime(num * 10 + i)) {
                    dfs(num * 10 + i, a + 1);
                }
            }
        }
        static boolean isPrime ( int numPri){
            for (int i = 2; i <= numPri / 2; i++) {
                if (numPri % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }