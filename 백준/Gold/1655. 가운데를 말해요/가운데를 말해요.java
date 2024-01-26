import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=  Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        while (n --> 0){
            int num = Integer.parseInt(br.readLine());
            if (maxQ.isEmpty()) maxQ.offer(num);
            else if (maxQ.size() == minQ.size()) maxQ.offer(num);
            else minQ.offer(num);

            if (!maxQ.isEmpty() && !minQ.isEmpty() && !(maxQ.peek() <= minQ.peek())){
                int a = maxQ.poll();
                int b = minQ.poll();
                maxQ.offer(b);
                minQ.offer(a);
            }
            sb.append(maxQ.peek()).append("\n");
        }
        System.out.println(sb);
    }
}