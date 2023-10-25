import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int snow1 = arr[i] + arr[j];
                int s = 0;
                int e = n -1;
                while (s < e) {
                    if (s == i || s == j) {
                        s++;
                        continue;
                    }
                    if (e == i || e == j) {
                        e--;
                        continue;
                    }
                    int snow2 = arr[s] + arr[e];
                    min = Math.min(min, Math.abs(snow1 - snow2));
                    if (snow1 > snow2) s++;
                    else if (snow1 < snow2) e--;
                    else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(min);
    }
}