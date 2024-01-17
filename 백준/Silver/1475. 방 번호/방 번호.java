import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] num = new int[10];
        for (int i= 0; i < n.length(); i++){
            int now = Character.getNumericValue(n.charAt(i));
            if (now == 6) num[9]++;
            else num[now]++;
        }
        int ans = 0;
        for (int i = 0; i < 9; i++) ans = Math.max(ans, num[i]);
        int card = (num[9] % 2 == 0) ? num[9]/2 : (num[9] /2) + 1;
        System.out.println(Math.max(ans, card));
    }
}