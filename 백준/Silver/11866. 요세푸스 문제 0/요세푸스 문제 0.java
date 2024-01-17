import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            q.offer(i);
        }
        sb.append("<");
        while (!q.isEmpty()){
            if (q.size() == 1) {
                sb.append(q.poll()).append(">");
                break;
            }
            for (int i = 1; i <= k; i++){
                if (i == k){
                    sb.append(q.poll()).append(", ");
                } else q.offer(q.poll());
            }
        }
        System.out.println(sb);
    }
}