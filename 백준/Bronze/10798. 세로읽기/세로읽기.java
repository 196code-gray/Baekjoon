import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] s = new String[5][16];
        for (int i = 0; i < 5; i ++){
            s[i] = br.readLine().split("");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 5; j++){
                if (i > s[j].length -1) continue;
                if (s[j][i].equals("")) continue;
                else sb.append(s[j][i]);
            }
        }
        System.out.println(sb);
    }
}
