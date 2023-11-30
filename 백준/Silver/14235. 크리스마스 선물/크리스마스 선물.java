import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());     // 우선순위 큐를 내림차순으로 선언
        for (int i = 0; i < n; i++) {   // n만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {  // 아이들을 만나지 않았을 경우
                for (int j = 0; j < num; j++) {     // 선물 수만큼 한번 더 반복
                    q.add(Integer.parseInt(st.nextToken()));    
                }
            } else {
                if (q.isEmpty()) System.out.println(-1);    // 선물을 가지고 있지 않을 경우 -1 출력
                else System.out.println(q.remove());    
            }
        }
    }
}