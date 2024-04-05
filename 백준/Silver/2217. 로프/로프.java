import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[n];
        for (int i = 0; i < n; i++) rope[i] = (Integer) Integer.parseInt(br.readLine());
        Arrays.sort(rope, Collections.reverseOrder());

        int max = rope[0];
        for (int i = 1; i < n;i++){
            max = Math.max(max, rope[i] * (i + 1));
        }
        System.out.println(max);
    }
}