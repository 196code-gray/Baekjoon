import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String back = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            back += s.substring(i, i + 1);
        }
        if (s.contains(back)) {
            System.out.println(s.length());
            return;
        } else {
            for (int i = 0; i < s.length(); i++) {
                back = s;
                for (int j = i; j >= 0; j--) {
                    back += s.substring(j, j + 1);
                }
                String ans = "";
                for (int j = back.length() - 1; j >= 0; j--) {
                    ans += back.substring(j, j + 1);
                }
                if (back.contains(ans)) {
                    System.out.println(back.length());
                    return;
                }
            }
        }
    }
}