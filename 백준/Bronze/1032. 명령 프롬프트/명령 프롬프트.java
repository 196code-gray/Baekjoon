import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n= Integer.parseInt(br.readLine());
        sb.append(br.readLine()); n--;
        while (n --> 0) {
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++){
                if (sb.charAt(i) != s.charAt(i)){
                    sb.setCharAt(i, '?');
                }
            }
        }
        System.out.println(sb);
    }
}