import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs("");
    }
    static void dfs(String s){
        if (s.length() == n){
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++){
            boolean isT = true;
            String now = s + i;
            for (int j = 1; j <= now.length() /2; j++){
                String first = now.substring(now.length()-j * 2, now.length() -j);
                String back = now.substring(now.length() - j, now.length());
                if (first.equals(back)) {
                    isT = false;
                    break;
                }
            }
            if (isT) dfs(s + i);
        }
    }
}