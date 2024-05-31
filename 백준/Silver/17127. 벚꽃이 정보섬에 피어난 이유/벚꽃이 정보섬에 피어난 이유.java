import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int a = 1;
        for (int i = 0; i < n-3; i++) {
            a *= arr[i];
            int b = 1;
            for (int j = i+1; j < n - 2; j++) {
                b *= arr[j];
                int c = 1;
                for (int k = j+1; k < n - 1; k++) {
                    c*= arr[k];
                    int d = 1;
                    for (int l = k+1; l < n; l++) {
                        d *= arr[l];
                    }
                    ans = Math.max(ans, a+b+c+d);
                }
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}