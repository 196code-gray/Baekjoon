import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 100) {
            System.out.println(n);
            return;
        }
        int ans = 99;
        for (int i = 100; i <= n && i != 1000; i++){
            String s = String.valueOf(i);
            int c = s.charAt(s.length() -1) - s.charAt(s.length() -2);
            for (int j = s.length() -2; j > 0; j--){
                if (c == s.charAt(j) - s.charAt(j -1)) ans++;
            }
        }
        System.out.println(ans);
    }
}