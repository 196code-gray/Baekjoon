import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());

        Integer[] plus, minus; plus = new Integer[n]; minus = new Integer[n]; // 양수, 음수
        int last = 0; int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n;i++){
            Integer now = Integer.parseInt(st.nextToken());

            if (now > 0) {
                plus[i] = now;
                minus[i] = 0;
            }
            else {
                minus[i] = Math.abs(now);
                plus[i] = 0;
            }

            last = Math.max(last, Math.abs(now)); // 제일 먼 거리 저장
        }
        // 제일 먼 거리가 먼저 오게 내림차순 정렬
        Arrays.sort(plus, Collections.reverseOrder());
        Arrays.sort(minus, Collections.reverseOrder());

        for (int i = 0; i < plus.length; i+= m){
            if (plus[i] == 0) break; // 현재 값이 0이라는 의미는 책이 없다는 의미 이므로 종료
            ans += plus[i] * 2; // 갔다가 다시 돌아오는 거리
        }
        for (int i = 0; i < minus.length; i+= m){
            if (minus[i] == 0) break; // 현재 값이 0이라는 의미는 책이 없다는 의미 이므로 종료
            ans += minus[i] * 2; // 갔다가 다시 돌아오는 거리
        }
        System.out.println(ans - last);
    }
}