import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n]; // 크레인
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) crane[i] = Integer.parseInt(st.nextToken());
        int max = 0;

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>(); // 박스
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
            max = Math.max(max, box.get(i));
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        int time, e; time = e = 0;

        while (true) {
            if (max > crane[0]) {  // 박스 최고 무게를 크레인이 들 수 없는 경으
                System.out.println(-1);
                return;
            }

            int craneIdx = 0;
            int boxIdx = 0;
            while (craneIdx < crane.length) {
                if (boxIdx == box.size()) break; // 박스가 이제 없는 경우
                if (crane[craneIdx] >= box.get(boxIdx)) {  // 현 크레인이 박스를 들 수 있는 경우
                    box.remove(box.get(boxIdx));
                    e++;
                    craneIdx++;  // 다음 크레인
                } else boxIdx++;
            }
            time++;
            if (e == m) break;
        }
        System.out.println(time);
    }
}