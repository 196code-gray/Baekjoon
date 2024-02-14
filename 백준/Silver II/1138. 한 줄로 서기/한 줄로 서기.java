import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tall = new int[n + 1];
        List<Integer> ans = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tall[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n; i >= 1; i--) {
            ans.add(tall[i], i);
        }

        for (int k : ans) {
            System.out.print(k + " ");
        }
    }
}