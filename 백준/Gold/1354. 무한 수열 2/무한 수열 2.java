import java.io.*;
import java.util.*;

public class Main {

    static long n;
    static int p, q, x, y;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        System.out.println(get(n));
    }

    static long get(long key) {
        if (map.get(key) == null) { put(key); }
        return map.get(key);
    }

    static void put(long key) {
        if (key <= 0L) {
            map.put(key, 1L);
        } else {
            map.put(key, get(key / p - x) + get(key / q - y));
        }
    }
}