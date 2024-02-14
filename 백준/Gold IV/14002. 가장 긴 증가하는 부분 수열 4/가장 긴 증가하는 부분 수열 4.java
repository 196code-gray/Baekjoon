import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n]; int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){    // 수 입력
            num[i] = Integer.parseInt(st.nextToken());
        }
        int len = 1;
        for (int i = 0; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (dp[i] < dp[j] + 1 && num[i] > num[j]) dp[i] = dp[j] + 1;
                if (len < dp[i]) len = dp[i];
            }
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        for (int i = n -1; i >= 0; i--){
            if (dp[i] == len){
                stack.push(num[i]);
                len--;
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop()). append(" ");
        System.out.println(sb);
    }
}