import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		dp = new int[101][101]; 

		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if (N > M) {
			int temp = N;
			N = M;
			M = temp;
		}

		bw.write((recursion(N, M) == 1) ? "A\n" : "B\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int recursion(int x, int y) {
		if (x == 0 || y == 0 || x > y) {
			return 0;
		}

		if (x == 1 && y == 1) {
			return 2;
		}

		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		dp[x][y] = 0;

		for (int i = 1; i <= y / 2; i++) {
			int temp = recursion(i, y - i);

			if (temp == 0 || temp == 2) {
				return dp[x][y] = 1;
			}
		}

		for (int i = 1; i <= x / 2; i++) {
			int temp = recursion(i, x - i);

			if (temp == 0 || temp == 2) {
				return dp[x][y] = 1;
			}
		}

		return dp[x][y];
	}

}