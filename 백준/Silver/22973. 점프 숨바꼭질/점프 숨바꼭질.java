import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                long K = Math.abs(Long.parseLong(br.readLine()));

        if (K == 0) {
            System.out.println(0);
        } else if (K % 2 == 0) {
            System.out.println(-1);
        } else {
            int ans = 0;
            while (K > 0) {
                K = K >> 1;
                ans++;
            }
            System.out.println(ans);
        }
            }
}