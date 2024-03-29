import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] box = new int[4]; // 사용중인 박스
        int[] card = new int[100];

        if (N == 0) {
            System.out.println(0);
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken()) + 1; // 카드 받고 1 증가
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            boolean inUse = false;
            for (int j = 0; j < 4; j++) {
                if (card[i] == box[j]) {
                    inUse = true;
                    break;
                }
            }
            if (inUse) continue;
            for (int j = 0; j < 4; j++) {
                if (box[j] == 0) {
                    box[j] = card[i];
                    inUse = true;
                    break;
                }
            }
            if (inUse) {
                result++;
                continue;
            }

            int swap = 0, val = -1;
            for (int j = 0; j < 4; j++) {
                int term = 0;
                for (int k = i + 1; k < N && box[j] != card[k]; k++) {
                    term++;
                }
                if (term > val) {
                    swap = j;
                    val = term;
                }
            }
            result++;
            box[swap] = card[i];
        }
        System.out.println(result);
    }
}