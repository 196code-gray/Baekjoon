import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()); long m = Long.parseLong(st.nextToken());
        
        long min = Long.MAX_VALUE; long max = 0;
        long[] time = new long[(int) n];
        for (int i = 0; i < n; i++){
            time[i] = Long.parseLong(br.readLine());
            min = Math.min(min, time[i]);  // 현재 입국심사 시간 제일 짧은 시간
            max = Math.max(max, time[i]);
        }
        
        long left = min; long right = max * m;
        while (left <= right){
            long mid = (left + right) / 2; // 중간값
            long cnt = 0; // 현재 가능한 인원 수
            
            for (int i = 0; i < n; i ++){
                cnt += mid/time[i];
                if (cnt >= m) break;
            }
            
            if (cnt < m) { // 현재 모든 인원 심사 불가(범위 작음)
                left = mid + 1;
            } else right = mid - 1;
        }
        
        System.out.print(left);
    }
}