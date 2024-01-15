import java.util.*;
import java.io.*;

class Main{
    static TreeMap<Integer, Integer> map;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            int k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            sort(k);
        }
        System.out.println(sb);
    }
    static void sort(int k) throws IOException {
        while (k --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (s.equals("I")) map.put(num, map.getOrDefault(num, 0) + 1);
            else {
                if (map.isEmpty()) continue;

                num = (num == 1) ? map.lastKey() : map.firstKey();
                map.put(num, map.get(num) -1);
                if (map.get(num) == 0) map.remove(num);
            }
        }
        sb.append((map.isEmpty()) ? "EMPTY" : map.lastKey() + " " + map.firstKey()).append("\n");
    }
}
