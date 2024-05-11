import java.io.*;
import java.util.*;

public class Main {
    static int n,m, MAX = 987654321;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n];

        int right = Integer.MIN_VALUE;
        String[] s1 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s1[i]);
            right = Math.max(arr[i],right);
        }

        int left= 0;

        while(left<right){
            int mid = (left+right)/2;
            if(solve(mid)<=m){ // m개 이하를 만족하는 경우
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
    private static int solve(int mid){
        int count = 1; // 현재 구간 개수
        int min = MAX; // 현재 구간에서 최솟값
        int max = -MAX; // 현재 구간에서 최댓값
        for(int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if(max - min > mid) {
                count++;
                max = -MAX; min = MAX;
                i--;
            }
        }
        return count;
    }
}