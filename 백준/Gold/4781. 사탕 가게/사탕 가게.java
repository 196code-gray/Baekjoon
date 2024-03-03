import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int money = (int) ((Double.parseDouble(st.nextToken()) * 100.0) + 0.5);
            if (n == 0 && money == 0) break;
            int[] dp = new int[money+1];

            for (int i = 1; i<= n; i++){
                st = new StringTokenizer(br.readLine());
                int kcal = Integer.parseInt(st.nextToken());
                int price = (int) ((Double.parseDouble(st.nextToken()) * 100.0) + 0.5);
                for (int j = price; j <= money; j++){
                        dp[j] = Math.max(dp[j], dp[j - price] + kcal);
                }
            }
            sb.append(dp[money]).append("\n");
        }
        System.out.println(sb);
    }
}