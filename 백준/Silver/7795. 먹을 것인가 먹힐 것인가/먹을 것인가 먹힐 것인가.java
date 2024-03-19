import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
            int[] A, B; A = new int[n+1]; B = new int[m+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) B[i] = Integer.parseInt(st.nextToken());
            int count = 0;

            Arrays.sort(A);
            Arrays.sort(B);
            for (int i = n; i > 0; i--){
                int s = m;
                while (s > 0){
                    if (A[i] > B[s]) {
                        count += s;
                        break;
                    }
                    else if (A[i] <= B[s]) s--;
                }
            }
            System.out.println(count);
        }
    }
}