import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        while (!q.isEmpty()) {
            int num = q.poll();
            if (!q.isEmpty()) {
                time += q.peek();
                q.add(num - q.poll());
            } else time += num;
        }
        time = (time > 1440) ? -1 : time;
        System.out.println(time);
    }
}