import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        if (n < 11) {
//            System.out.println(0);
//            return;
//        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++){
            int now = i;
            int b = i;
            while (b > 0){
                int a = b % 10;
                now += a;
                b /= 10;
            }
            if (now == n){
                if (min > i) min = i;
            }
        }
        System.out.println((min == Integer.MAX_VALUE) ? 0 : min);
    }
}