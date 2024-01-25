import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n];
        while (m --> 0){
            st =new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) -1;
            int j= Integer.parseInt(st.nextToken()) -1;
            int k = Integer.parseInt(st.nextToken());
            for (int w = i; w <= j; w++) basket[w] = k;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : basket) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}