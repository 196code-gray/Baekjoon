import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        String ans = "";
        for (int i= 0; i< s.length(); i++){
            if ((s.charAt(i) - 97) >= 0) ans += String.valueOf(s.charAt(i)).toUpperCase();
            else ans += String.valueOf(s.charAt(i)).toLowerCase();
        }
        System.out.println(ans);
    }
}