import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        while (Integer.bitCount(n) > k){
            ans++;
            n++;
        }
        System.out.println(ans);
    }
}