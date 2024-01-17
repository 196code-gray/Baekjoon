import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t --> 0){
            Deque<Integer> d = new ArrayDeque<>();
            boolean up = true;
            String ac = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine().replace("[", "").replace("]", "");
            String[] ss = s.split(",");
            boolean error = false;

            for (int i = 0; i < n; i++){
                d.offer(Integer.parseInt(ss[i]));
            }
            for (int i = 0; i < ac.length(); i++){
                if (ac.charAt(i) == 'R') up = (up) ? false : true;
                else {
                    if (d.isEmpty()) {
                        sb.append("error").append("\n");
                        error = true;
                        break;
                    }
                    if (up) d.pollFirst();
                    else d.pollLast();
                }
            }
            if (!d.isEmpty()) {
                sb.append("[");
                while (!d.isEmpty()){
                    if (up) sb.append(d.pollFirst());
                    else if (!up) sb.append(d.pollLast());
                    if (d.size() != 0) sb.append(",");
                }
                sb.append("]").append("\n");
            } else if (d.isEmpty() && !error) sb.append("[").append("]").append("\n");
        }
        System.out.println(sb);
    }
}