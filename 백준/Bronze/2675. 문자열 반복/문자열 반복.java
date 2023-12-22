import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-->0){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); String s = st.nextToken();
            for (int i = 0; i < s.length();i++){
                sb.append(s.substring(i, i + 1).repeat(r));
            }
            System.out.println(sb);
        }
        }
    }