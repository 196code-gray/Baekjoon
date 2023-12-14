import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (n --> 0) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st =new StringTokenizer(br.readLine());
        while (m --> 0) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) sb.append(map.get(num)).append(" ");
            else sb.append("0").append(" ");
        }
        System.out.println(sb);
    }
}