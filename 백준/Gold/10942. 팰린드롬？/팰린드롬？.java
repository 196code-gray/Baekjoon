import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static boolean[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
	
		num = new int[n+1];
		dp = new boolean[n+1][n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= n; i++){
			dp[i][i] = true;
		}
		
		for(int i=1; i<=n-1; i++) {
			if(num[i] == num[i+1]) dp[i][i+1] =true;
		}
		checkPalin(n);
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
		 st = new StringTokenizer(br.readLine());
		 int start = Integer.parseInt(st.nextToken());
		 int end = Integer.parseInt(st.nextToken());
		 
		 if(dp[start][end]) {
			sb.append("1\n");
		 }
		 else {
			 sb.append("0\n");
		 }
		}
		 
		 System.out.println(sb);
	}
	
	static void checkPalin(int n) {
	
		for(int i=2; i<n; i++) {
			for(int j=1; j<=n-i; j++) {
				if(num[j] == num[j+i] && dp[j+1][j+i-1]) {
					dp[j][j+i] = true;
				}
			}
		}
		
	}
}