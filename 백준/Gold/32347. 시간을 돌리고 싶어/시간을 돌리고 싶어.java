import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] arr, future;
	
	static int binarySearch() {
		int s = 1;
		int e = N - 1;
		int ans = N - 1;
		while (s <= e) {
			int mid = (s + e) >> 1;
			int k = 0; 
			int cur = N - 1; 
			while (k < K) {
				k += 1;
				if (arr[cur] == 1) {
					cur -= mid;
				} else {
					cur = future[cur] - mid;
				}
				cur = Math.max(cur, 0);
				if (cur == 0) break;
			}
			
			if (k <= K && cur == 0) { 
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}

		}
		
		return ans;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		future = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int day = N - 1; 
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] == 1) {
				future[i] = i;
				day = i;
			} else { 
				future[i] = day;
			}
		}
		
		int t = binarySearch();
		System.out.println(t);
		
	}
}