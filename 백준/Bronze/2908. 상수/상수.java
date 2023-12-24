import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] c1=st.nextToken().toCharArray();
        char[] c2 = st.nextToken().toCharArray();
        String s1 = String.valueOf(c1[2]) + String.valueOf(c1[1]) + String.valueOf(c1[0]);
        String s2 = String.valueOf(c2[2]) + String.valueOf(c2[1]) + String.valueOf(c2[0]);
        if (Integer.parseInt(s1) > Integer.parseInt(s2)) System.out.println(s1);
        else System.out.println(s2);
    }
    }