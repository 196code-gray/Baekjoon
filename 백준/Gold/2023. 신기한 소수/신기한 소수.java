import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0, 0);
        System.out.println(sb);
    }
    static void dfs(int depth, int ans){
        if (depth == N){
            sb.append(ans).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i++){
            int now = ans * 10 + i;
            if (!isPrime(now)) continue;
            dfs(depth + 1, now);
        }
    }
    static private boolean isPrime(int num){
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}