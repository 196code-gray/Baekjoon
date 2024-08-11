import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        
        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(bf.readLine());
        for(int i = 0; i < t; i++) {
            String str = bf.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
 
            int[] home = new int[n];
            str = bf.readLine();
            st = new StringTokenizer(str);
            int total = 0;
            for(int j = 0; j < n; j++) {
                home[j] = Integer.parseInt(st.nextToken());
                total += home[j];
            }
 
            if(n == m) {
                if(total < k) System.out.println("1");
                else System.out.println("0");
            } else {
                int count = 0;
 
                int start = 0;
                int end = m - 1;
                int sum = 0;
                for(int j = 0; j <= end; j++) {
                    sum += home[j];
                }
 
                while(start < n) {
                    if(sum < k) count++;
                    sum -= home[start++];
                    sum += home[(++end) % n];
                }
                System.out.println(count);
            }
        }
    }
}