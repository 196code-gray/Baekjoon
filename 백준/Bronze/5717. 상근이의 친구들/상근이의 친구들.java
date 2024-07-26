import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int m = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            if (m == 0 && f == 0)
                break;

            System.out.println(m + f);
        }

    }
}