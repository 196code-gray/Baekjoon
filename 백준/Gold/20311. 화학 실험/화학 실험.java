import java.util.*;
import java.io.*;

public class Main {
	static int n,k;
    static BufferedReader br;
    static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		 br = new BufferedReader(new InputStreamReader(System.in));
		 st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=k; i++) {
			int count = Integer.parseInt(st.nextToken());
			if((n % 2 == 0 && n / 2 < count) || (n % 2 == 1 && (n+1) / 2 < count)) {
				System.out.println(-1);
				return;
			}
			pq.offer(new int[] {i,count});
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			for(int i=0; i<tmp[1]; i++)
				dq.offerLast(tmp[0]);
		}
		int[] ary = new int[300001];
		for(int i=0; i<n; i+=2)
			ary[i] = dq.pollFirst();
		for(int i=1; i<n; i+=2)
			ary[i] = dq.pollFirst();	
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++)
			sb.append(ary[i]+" ");
		System.out.println(sb.toString());
	}
}