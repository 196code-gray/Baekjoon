import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()); int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String n = String.valueOf(a * b * c);

        for (int i = 0; i <= 9; i++){
            int result = n.length() - n.replace(String.valueOf(i), "").length();
            System.out.println(result);
        }
        }
    }