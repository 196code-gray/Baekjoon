import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(1, "2");
        dfs(1, "3");
        dfs(1, "5");
        dfs(1, "7");
        System.out.println(sb);
    }
    static void dfs(int depth, String ans){
        if (depth == N){
            sb.append(ans).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i++){
            int now = Integer.parseInt(ans + i);
            if (isPrime(now)) continue;
            dfs(depth + 1, String.valueOf(now));
        }
    }
    static private boolean isPrime(int num){
        for (int i = 2; i <= num/2; i++){
            if (num % i == 0) return true;
        }
        return false;
    }
}