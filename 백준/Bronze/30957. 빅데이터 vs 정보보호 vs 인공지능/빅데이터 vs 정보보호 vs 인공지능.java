import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int s, b, a;
        s = b = a =0;
        for (int i = 0; i < str.length; i++){
            switch (str[i]){
                case ("S"):
                    s++;
                    break;
                case "B" :
                    b++;
                    break;
                case "A":
                    a++;
                    break;
            }
        }
        if (s == b && b== a) System.out.println("SCU");
        else if (b > s && b > a) System.out.println("B");
        else if (a > b && a > s) System.out.println("A");
        else if (s > b && s > a) System.out.println("S");
        else if (b == a) System.out.println("BA");
        else if (s == b) System.out.println("BS");
        else if (s == a) System.out.println("SA");
    }
}