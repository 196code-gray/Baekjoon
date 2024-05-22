import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] s = new String[c];

        for (int i = 0; i < r; i++) {
            String now = br.readLine();
            for (int j = 0; j < c; j++) {
                if (i == 0) s[j] = String.valueOf(now.charAt(j));
                else s[j] = s[j] + String.valueOf(now.charAt(j));
            }
        }

        if (r == 2) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i < r -1; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < c; j++) {
                String key = s[j].substring(i);
                if (set.contains(key)) {
                    System.out.println(i -1);
                    return;
                }
                set.add(key);
            }
        }
        System.out.println(r -1);
    }
}