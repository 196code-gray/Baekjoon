import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int K = Integer.valueOf(str[1]);

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (queue.size() != 1) {
			for (int i = 1; i < K; i++) {
				queue.offer(queue.poll());
			} // end of for
			sb.append(queue.poll() + ", ");
		}
		sb.append(queue.poll() + ">");
		System.out.println(sb);
    }
}