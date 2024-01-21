import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 2*n-1; i >= 1; i -= 2){
            String s = ("*").repeat(i);
            int len = (((n*2-1) - i) / 2);
            if (len == 0) System.out.print(s);
                else{
                System.out.printf("%-" + len + "s", "");
                System.out.print(s);
            }
            System.out.println();
        }
        for (int i = 3; i <= 2*n-1; i+= 2){
            String s = ("*").repeat(i);
            int len = (((n*2-1) - i) / 2);
            if (len == 0) System.out.print(s);
            else {
                System.out.printf("%-" + len + "s", "");
                System.out.print(s);
            }
            System.out.println();
        }
    }
}