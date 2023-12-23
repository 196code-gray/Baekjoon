import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        int[] abc = new int[26];

        for (int i = 0; i<s.length();i++){
            abc[s.charAt(i) - 65] += 1;
        }
        char m = ' ';
        int max = 0;
        for (int i = 0; i<abc.length; i++){
            if (abc[i] > max) {
                max = abc[i];
                m = (char) (65+i);
            }
        }

        Arrays.sort(abc);
        if (abc[abc.length -1] == abc[abc.length - 2]) System.out.println("?");
        else System.out.println(m);
        }
    }