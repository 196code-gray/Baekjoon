import java.util.*;
import java.io.*;

public class Main {
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arrA = new int[A];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrA.length; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrA);
		
		int[] arrB = new int[B];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrB.length; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrB);
		
		int[] arrC = new int[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrC.length; i++) {
			arrC[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrC);
		
		for (int i = 0; i < arrA.length; i++) {
			int selectA = arrA[i];
			int selectB = nearestNum(selectA,arrB);
			int selectC1 = nearestNum(selectA,arrC);
			int selectC2 = nearestNum(selectB,arrC);
			int max1 = Math.max(Math.max(selectA, selectB),selectC1);
			int min1 = Math.min(Math.min(selectA, selectB),selectC1);
			int score1 = max1 - min1;
			
			int max2 = Math.max(Math.max(selectA, selectB),selectC2);
			int min2 = Math.min(Math.min(selectA, selectB),selectC2);
			int score2 = max2 - min2;
			
			answer = Math.min(answer,Math.min(score1,score2));
		}
		System.out.println(answer);
		
		
	}
	
	public static int nearestNum(int target, int[] arr) {
		int startIdx = 0;
		int endIdx = arr.length-1;
		int mid = (startIdx + endIdx)/2;
		int nearest = arr[mid];
				
		while(startIdx <= endIdx) {
			mid = (startIdx + endIdx)/2;
			if(arr[mid] == target) return target;
			if(arr[mid] < target) {
				startIdx = mid+1;
			}else if(arr[mid] > target) {
				endIdx = mid-1;
			}
			if(isMoreApproximated(arr[mid],nearest,target)) {
				nearest = arr[mid];
			}
		}
		return nearest;
	}
	
	public static boolean isMoreApproximated(int selectedNum, int nearest, int target) {
		if(Math.abs(selectedNum-target) < Math.abs(nearest - target)) return true;
		return false;
	}
}