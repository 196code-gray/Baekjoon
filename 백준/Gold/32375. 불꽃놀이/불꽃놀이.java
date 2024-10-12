import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        List<Long> v = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(v);

        long idx = 0;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            if (v.get(i) >= m) {
                idx = i;
                find = true;
                break;
            }
        }

        if (!find) {
            idx = n;
        }

        long result = n - idx;
        int start = 0;
        int end = (int) idx - 1;
        
        while (start < end) {
            if (v.get(start) + v.get(end) >= m) {
                start++;
                end--;
                find = true;
                result++;
            } else {
                start++;
            }
        }

        if (!find) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}