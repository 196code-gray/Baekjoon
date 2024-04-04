import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sushi = new int[3001]; // 초밥 종류
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] dish = new int[n]; // 초밥 개수
        for (int i = 0; i < n; i++)
            dish[i] = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        int result = 0; // 결과
        int cnt = 0;

        // 일단 덱에 k개 만큼 넣기
        for (int i = 0; i < k; i++) {
            int val = 0;
            dq.addLast(dish[i]);
            // 새로운 초밥 종류일때
            if (sushi[dish[i]] == 0) {
                cnt++; // 개수+1
            }
            sushi[dish[i]]++;
        }
        result = cnt;

        for (int i = 0; i < dish.length; i++) {
            int del = dq.pollFirst(); // 가장 앞에 있는 뺄거
            sushi[del]--; // 빼줌
            if (sushi[del] == 0) // 안에 더이상 없으면 삭제
                cnt--;

            dq.addLast(dish[(i + k) % n]); // 원형이니까 처음으로 돌아감
            if (sushi[dish[(i + k) % n]] == 0) // 새로운 초밥이면 종류+1
                cnt++;
            sushi[dish[(i + k) % n]]++;

            // 덱에 쿠폰에 해당하는 초밥이 없을 때
            if (sushi[c] == 0) {
                result = Math.max(result, cnt + 1);
            }
            // 덱에 쿠폰에 해당하는 초밥이 있을 때
            else result = Math.max(result, cnt);
        }
        System.out.println(result);
    }
}