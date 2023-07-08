import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        int[] result = new int[n];

        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(ss[i]);
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                result[stack.pop()] = (int) a[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();

    }
}