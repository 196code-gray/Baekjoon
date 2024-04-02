import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] load, gas; load = new int[n -1]; gas = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n -1; i++) {
            load[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            gas[i] = Integer.parseInt(st.nextToken());
        }
        long price = 0;
        long now = gas[0]; int idx = 0;

        for (int i = 1; i < n; i++){
            if (gas[i] >= now) continue;

            long plus = 0;
            for (int j = idx; j < i; j++){
                plus += load[j] * now;
            }
            price += plus;
            idx = i;
            now = gas[i];
        }

        if (idx != n-1){
            long pp = 0;
            for (int i = idx; i < n-1; i++){
                pp += load[i] * now;
            }
            price += pp;
        }
        System.out.println(price);
    }
}