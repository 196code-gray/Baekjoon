import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n + 1];
        for (int i = 1; i <= n; i++) basket[i] = i;

        while (m --> 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int i = s; i < e; i++){
                int now = basket[i];
                basket[i] = basket[e];
                basket[e--] = now;
            }
        }
        for (int i = 1; i <= n; i++){
            System.out.print(basket[i] + " ");
        }
    }
}