import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int s, e; s = e = 0;
        while (n > e){
            s++;
             e+= s;
        }
        int d = e - n;
        if (s % 2 == 0){
            int a = s-d;
            int b = d+1;
            System.out.println(a+"/"+b);
            return;
        }
        else {
            int a = d+1;
            int b = s-d;
            System.out.println(a+"/"+b);
        }
    }
}