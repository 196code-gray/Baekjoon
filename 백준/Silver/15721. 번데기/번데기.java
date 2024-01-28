import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int repeat = 2; int zero, one; zero = one = 0;

        while(true){
            for (int i= 0; i < 4; i++){
                if (i % 2 ==0) zero++;
                else if (i % 2 != 0) one++;

                if (zero == t && n == 0){
                    System.out.println((zero + one -1) % a);
                    return;
                }
                if (one == t && n == 1){
                    System.out.println((zero + one -1) % a);
                    return;
                }
            }
            for (int i = 0; i < repeat; i++){
                zero++;
                if (zero == t && n == 0){
                    System.out.println((zero + one -1) % a);
                    return;
                }
            }
            for (int i= 0; i < repeat; i++){
                one++;
                if (one == t && n == 1){
                    System.out.println((zero + one -1) % a);
                    return;
                }
            }
            repeat++;
        }
    }
}