import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;

    static public void main(String[] arg) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        boolean isTrue = false;

        for (int i = 0; i < len / 2; i++){
            if (s.charAt(i) != s.charAt(len - i - 1)) { // 처음과 끝이 다르다면 바로 리턴
                System.out.println(len);
                return;
            } else if (s.charAt(i) != s.charAt(i + 1)) isTrue = true;
        }

        if (isTrue) System.out.println(len - 1);
        else System.out.println(-1);
    }
}