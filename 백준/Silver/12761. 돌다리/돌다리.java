import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] list;
	static int[] answer;
	static int cnt;
    static BufferedReader br;
    static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		 br = new BufferedReader(new InputStreamReader(System.in));
		 st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new int[M + 1];
		answer = new int[100001];

		bfs(A, B, N, M, list, answer);

	}

	private static void bfs(int A, int B, int N, int M, int[] list, int[] answer) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		int[] move = { 1, -1, -A, A, -B, B};
		int[] jump = {A, B};
		cnt = 0;
		
		while (!q.isEmpty()) {

			int size = q.size();

			for (int k = 0; k < size; k++) {

				int now = q.poll();
                
				for (int i = 0; i < 6; i++) {

					int next = now + move[i];

					if (next < 0 || next >= 100001) {
						continue;
					}

					if (answer[next] != 0) {
						continue;
					}
					
					if (next == M) {
						System.out.println(cnt + 1);
						return;
					}
					answer[next] = answer[now] + 1;
					q.add(next);

				}
				for (int i = 0; i < 2; i++) {

					int next = now * jump[i];

					if (next < 0 || next >= 100001) {
						continue;
					}

					if (answer[next] != 0) {
						continue;
					}
					
					if (next == M) {
						System.out.println(cnt + 1);
						return;
					}
					answer[next] = answer[now] + 1;
					q.add(next);
				}
			}
			cnt++;
		}
	}
}