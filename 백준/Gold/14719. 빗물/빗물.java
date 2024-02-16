import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()); int w = Integer.parseInt(st.nextToken());
        int[] block= new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) block[i] = Integer.parseInt(st.nextToken());

        if (w == 1) {
            System.out.println(0);
            return;
        }
        int rain = 0;
        for (int i = 1; i < w -1; i++){
            int left, right; left = right = 0;
            for (int j = 0; j < i; j++){    // 현재 블록보다 왼쪽으로 더 큰 블록 찾기
                if (block[i] < block[j] && left < block[j]) left = block[j];
            }
            for (int j = i; j < w; j++){    // 오른쪽에서 더 큰 블록 찾기
                if (block[i] < block[j] && right < block[j]) right = block[j];
            }
            if (right != 0 && left != 0) {
                rain += Math.min(right, left) - block[i];
            }
        }
        System.out.println(rain);
    }
}