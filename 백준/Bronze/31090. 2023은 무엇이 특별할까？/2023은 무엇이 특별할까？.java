import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            int n = Integer.parseInt(br.readLine());
            if (n % 100 == 0) {
                System.out.println("Bye");
                return;
            }
            System.out.println(((n + 1)  % (n % 100) == 0) ? "Good" : "Bye");
        }
    }
}