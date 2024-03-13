import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M --> 0){
            st = new StringTokenizer(br.readLine());
            int s= Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            boolean t = true;
            while (s < e){
                if (num[s++] != num[e--]){
                    t = false;
                    sb.append("0").append("\n");
                    break;
                }
            }
            if (t) sb.append("1").append("\n");
        }
        System.out.println(sb);
    }
}