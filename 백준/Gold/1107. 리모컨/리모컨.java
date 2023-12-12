import java.io.*;
import java.util.*;

public class Main {
	static boolean digit[]=new boolean[10];
	static int answer,n;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		answer=Math.abs(n-100);
		Arrays.fill(digit, true);
		int m=Integer.parseInt(br.readLine());
		if(m>0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) digit[Integer.parseInt(st.nextToken())]=false;
		}
		dfs(0,0);
		System.out.println(answer);
	}
	static void dfs(int v,int val) {
		if(v>0) {
			int res=Math.abs(val-n)+v;
			answer=answer>res?res:answer;
		}
		if(v==6) return;
		for(int i=0;i<=9;i++) {
			if(digit[i]) {
				val+=Math.pow(10, v)*i;
				dfs(v+1,val);
				val-=Math.pow(10, v)*i;
			}
		}
	}
}