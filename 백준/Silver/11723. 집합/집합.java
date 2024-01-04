import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int s = 0;
        StringBuilder sb = new StringBuilder();

        while (m --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            if (now.equals("all")) s=(1<<21) -1;
            else if (now.equals("empty")) s=0;
            else {
                int i = Integer.parseInt(st.nextToken());
                if (now.equals("add")) s |= (1 << i);
                else if (now.equals("remove")) s &= ~(1 << i);
                else if (now.equals("toggle")) s ^= (1 << i);
                else if (now.equals("check")) sb.append((s & (1 << i)) != 0 ? 1 : 0).append("\n");
            }
        }
        System.out.println(sb);
    }
}