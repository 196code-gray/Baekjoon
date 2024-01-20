import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int a = s.length() / 10;
        for (int i = 0; i < a*10; i += 10){
                sb.append(s.substring(i, i + 10)).append("\n");
        }
        if (s.length() - (a*10) != 0) sb.append(s.substring((a * 10), s.length())).append("\n");
        System.out.println(sb);
    }
}