import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        String[][] light = new String[n][1];
        for (int i = 0;i < n; i++){
            light[i][0] = br.readLine();
        }
        int k = Integer.parseInt(br.readLine());
        int ans = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
                int len = light[i][0].replace("1", "").length();
                if (k >= len && k % 2 == len % 2) {
                    if (map.containsKey(light[i][0])) {
                        map.put(light[i][0], map.get(light[i][0]) + 1);
                    } else {
                        map.put(light[i][0], 1);
                    }
                }
        }
        for (Integer value : map.values()) {
            ans= Math.max(ans, value);
        }
        System.out.println(ans);
    }
}