import java.util.*;
import java.io.*;

public class Main {
	static int arr[];
    static BufferedReader in;
    static StringTokenizer st;
    static int D,N;
	public static void main(String[] args) throws IOException {
		 in = new BufferedReader(new InputStreamReader(System.in));
		 st =new StringTokenizer(in.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st =new StringTokenizer(in.readLine());
		arr = new int[D];
		for(int i=0; i<D; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<D; i++) {
			if( arr[i-1] < arr[i]) {
				arr[i] = arr[i-1];
			}
		}
		int low=-1; 
		int high=D-1;
		Arrays.sort(arr);
		st =new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			low=search(++low, high, n);
			if(low==-1)
				break;
		}
		if(low==-1)
			System.out.println(0);
		else
			System.out.println(D-low);
	}
	static int search(int low, int high, int target) {
		boolean flag = false;
		while(low < high) {
			int mid = (low+high)/2;
			if(target <= arr[mid]) {
				high = mid;
				flag=true;
			}else {
				low = mid+1;
			}
		}
		if(flag)
			return high;
		else
			return -1;
	}
}