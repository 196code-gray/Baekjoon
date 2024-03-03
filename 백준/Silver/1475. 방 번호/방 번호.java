import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        int[] set = new int[10]; // 0부터 9까지
        for (int i = 0; i < s.length; i++){
            int now = s[i].charAt(0)-'0';
            if (now == 6) now = 9;
            set[now]++;
        }
        int ans = 0;
        if (set[9] % 2 == 0) set[9] /= 2;
        else set[9] = set[9] / 2 + 1;
        for (int i =0; i < 10; i++){
            ans = Math.max(ans, set[i]);
        }
        System.out.println(ans);
    }
}