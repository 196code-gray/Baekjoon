import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean result = true;

        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int num = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] >= num) {
                while (arr[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                int a = stack.pop();
                if (arr[i] < a) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else sb.append("-\n");
            }
        }
        if (result) System.out.println(sb);
    }
}