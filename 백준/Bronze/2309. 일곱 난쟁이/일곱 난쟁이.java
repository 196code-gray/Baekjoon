import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = new int[9];
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[9];
        Arrays.sort(num);
        dfs(0, 0);
    }

    static void dfs(int depth, int sum) {
        if (depth == 7 && sum == 100){
            String s = "";
            for (int i = 0; i < 9; i++){
                if (visited[i]) s += String.valueOf(num[i]) + "\n";
            }
            System.out.println(s);
            System.exit(0);
        }
        if (sum > 100) return;
        if (depth == 7) return;

        for (int i = 0; i < 9; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(depth + 1, sum += num[i]);
                sum -= num[i];
                visited[i] = false;
            }
        }
    }
}