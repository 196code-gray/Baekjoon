import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int i = 1;
        while (queue.size() != 1) {
            if (i % 2 != 0) {
                queue.poll();
                i++;
            }
            else {
                queue.add(queue.poll());
                i++;
            }
        }
        System.out.println(queue.poll());
    }
}