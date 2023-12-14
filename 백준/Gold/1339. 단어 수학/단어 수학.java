import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];        // 알파벳 전체
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[s.charAt(j) - 65] += (int) Math.pow(10, s.length() -1 - j); 
            }
        }
        Arrays.sort(arr);
        int num = 9;
        int now = 25;
        int ans = 0;
        while (arr[now] != 0) {
            ans += arr[now] * num;
            num--;
            now--;
        }
        System.out.println(ans);
    }
}