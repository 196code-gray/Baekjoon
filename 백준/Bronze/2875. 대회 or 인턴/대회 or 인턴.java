import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        while (k --> 0){
            if (n /2 >= m) n--;
            else m--;
        }
        System.out.println(Math.min(n /2, m));
    }
}