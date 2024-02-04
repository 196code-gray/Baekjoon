import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int now = Integer.parseInt(st.nextToken());
                if (s.equals("I")) {
                    map.put(now, map.getOrDefault(now, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    int last = (now == 1) ? map.lastKey() : map.firstKey();
                    map.put(last, map.get(last) -1);
                    if (map.get(last) == 0) map.remove(last);
                }
            }
            sb.append((map.isEmpty()) ? "EMPTY" : map.lastKey() + " " + map.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}