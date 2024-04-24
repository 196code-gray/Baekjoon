import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stick = new int[n];
        long len, ans; len = 0; ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n;i++) {
            stick[i] = Integer.parseInt(st.nextToken());
            len += stick[i];
        }
                Arrays.sort(stick);

        for (int i = 0; i < n-1; i++){
            len -= stick[i];
            ans += len * stick[i];
        }
        System.out.println(ans);
    }
}