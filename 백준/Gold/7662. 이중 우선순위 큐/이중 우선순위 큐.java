import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
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
        System.out.println(sb);
    }
}