import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 오리 소리 횟수
        int k = Integer.parseInt(st.nextToken());   // 공백 시간
        int[] arr = new int[n];     // 오리 소리 시간 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int time = arr[0];
        for (int i = 1; i < n ; i++) {
            if (arr[i] > k + time) {      // 다음 시간이 현재 시간과 공백보다 크다면(이 때 치지않으면 오리 집에 감)
                count++;
                time = arr[i];
            }
        }
        System.out.println(count + 1);
    }
}