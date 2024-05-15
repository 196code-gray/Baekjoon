import java.io.*;
import java.util.*;
    
public class Main {
    static int[] arr;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());  k = Integer.parseInt(st.nextToken());

         arr = new int[n]; int left = 0; int right = 0;
         st= new StringTokenizer(br.readLine());
         for (int i = 0;i < n; i++){
             arr[i] = Integer.parseInt(st.nextToken());
             right += arr[i];  // 총 맞은 점수(최댓값)
         }

         while (left <= right){
             int mid = (left + right) / 2;
             if (possible(mid) < k){  // 현재 중간값이 나눠야 하는 구간보다 작은 경우(중간값이 너무 큰 경우)
                 right = mid -1;
             } else { // 반대의 경우
                 left = mid + 1;
             }
         }

        System.out.println(right);
    }
    static int possible(int m){
        int temp = 0, cnt = 0;  // 맞은 개수, 구간 개수
        for (int i = 0; i < n; i++){
            temp += arr[i];
            if (temp >= m){
                cnt++;
                temp=0;
            }
        }
        return cnt;
    }
}