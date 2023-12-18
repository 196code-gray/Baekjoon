import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meeting = new int[100_000][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.sort(meeting, Comparator.comparingInt(a -> a[0]));

        for (int[] i : meeting) {
            int s = i[0];
            int e = i[1];
            if (!q.isEmpty() && q.peek() <= s) q.poll();

            q.add(e);
        }
        System.out.println(q.size());
    }
}