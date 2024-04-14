import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] train = new int[n];  // 기차

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 1 || num == 2) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                if (num == 1) train[i -1] |= (1 << x);
                else train[i -1] &= ~(1 << x);
            }
            else {
                int i = Integer.parseInt(st.nextToken());

                if (num == 3) {
                    train[i -1] = (train[i -1] << 1); // 현재 train[i -1] 기차를 1 비트 뒤로
                    train[i -1] &= ((1 << 21) -1); // 전체 1로 설정 후 AND 연산
                }
                else {
                    train[i - 1] = (train[i - 1] >> 1); // 1 비트 앞으로
                    train[i-1] &= ~1;
                }
            }

        }
        Set<Integer> s = new HashSet<>();
        for (int i : train) {
            s.add(i);
        }
        System.out.println(s.size());
    }
}